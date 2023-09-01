import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  templateUrl: './reg-page.component.html',
  styleUrls: ['./reg-page.component.scss']
})
export class RegPageComponent implements OnInit{

  f!:FormGroup;

  constructor(private authSvc:AuthService, private router:Router){}

  ngOnInit(): void {
    this.f=new FormGroup({
      name: new FormControl(""),
      cognome: new FormControl(""),
      username: new FormControl("", Validators.required),
      email: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    });
  }

  submit(){
    this.authSvc.register(this.f.value).subscribe(res=>{
      this.router.navigate(["/login"]);
    });
  }
}
