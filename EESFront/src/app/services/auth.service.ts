import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { IRegUser } from '../models/ireg-user';
import { ILogUser } from '../models/ilog-user';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { IUser } from '../models/iuser';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedUser=new BehaviorSubject<null | IUser>(null);
  isUserLogged=this.loggedUser.asObservable();
  private storageUser:IUser;

  constructor(private http:HttpClient, private router:Router){
    this.storageUser=JSON.parse(localStorage.getItem("user")!);
    if(this.storageUser) this.loggedUser.next(this.storageUser);
  }

  register(user:IRegUser)
  {
    return this.http.post(environment.registrazione, user);
  }

  login(user:ILogUser){
    this.http.post<IUser>(environment.login, user).subscribe(u=>{
      this.loggedUser.next(u);
      localStorage.setItem("user", JSON.stringify(u));
      this.router.navigate(["/clienti"]);
    });
  }

  logout(){
    this.loggedUser.next(null);
    localStorage.removeItem("user");
    this.router.navigate(["/"]);
  }
}
