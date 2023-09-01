import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { ICliente } from '../models/icliente';
import { IUser } from '../models/iuser';
import { AuthService } from './auth.service';
import { Page } from '../models/page';

@Injectable({
  providedIn: 'root'
})
export class ClientiService {

  private user: IUser | null = null;
  private headers:HttpHeaders | undefined;

  constructor(private authSvc: AuthService, private http:HttpClient) {
    authSvc.isUserLogged.subscribe(user => {
      this.user = user
      this.headers=new HttpHeaders({
        'Authorization': `Bearer ${this.user?.accessToken}`
      });
    });
  }

  getCliente(id:number){
    return this.http.get<ICliente>(environment.clienti+"/"+id, {headers: this.headers});
  }

  getPage(nPagina:number, size:number){
    return this.http.get<Page>(environment.clienti+"?page="+nPagina+"&size="+size, {headers: this.headers});
  }
}
