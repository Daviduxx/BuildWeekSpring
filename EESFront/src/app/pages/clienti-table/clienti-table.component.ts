import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { ICliente } from 'src/app/models/icliente';
import { IUser } from 'src/app/models/iuser';
import { Page } from 'src/app/models/page';
import { AuthService } from 'src/app/services/auth.service';
import { ClientiService } from 'src/app/services/cliente.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-clienti-table',
  templateUrl: './clienti-table.component.html',
  styleUrls: ['./clienti-table.component.scss']
})
export class ClientiTableComponent implements OnInit {

  protected clienti: ICliente[] = [];
  loading: boolean = true;
  protected user: IUser | null = null;
  protected isAdmin: boolean = false;
  protected clientiDaEliminare:ICliente[]=[];

  protected page: Page = {
    content: [],
    empty: false,
    first: false,
    last: false,
    number: 0,
    numberOfElements: 0,
    pageable: [],
    size: 0,
    sort: [],
    totalElements: 0,
    totalPages: 0
  };

  constructor(private clientiSvc: ClientiService, private authSvc: AuthService, private messageService: MessageService) {
    authSvc.isUserLogged.subscribe(user => {
      this.user = user;
      this.user?.roles.forEach(r => {
        if (r.roleName === "ROLE_ADMIN") this.isAdmin = true
      });
    });

    this.clientiSvc.getPage(0, 10).subscribe(c => {
      this.page = c;
      this.clienti = c.content;
      console.log(c);
      console.log(this.clienti);
      this.loading = false;
    });
  }

  ngOnInit() {

  }

  eliminaClienti(){
    const idArr:number[]=this.clientiDaEliminare.map(el=>el.id);
    console.log(idArr);
    this.clientiSvc.eliminaClienti(idArr).subscribe(res=>{
      console.log(res);
      this.clientiDaEliminare=[];
    });
  }

  ciSonoElementiDaEliminare(){
    return this.clientiDaEliminare.length>0;
  }

  aggiungiClienteDaEliminare(c:any){
    this.clientiDaEliminare.push(c.data);
    console.log(this.clientiDaEliminare)
  }

  rimuoviClienteDaEliminare(c:any){
    this.clientiDaEliminare = this.clientiDaEliminare.filter(cliente => cliente.id !== c.data.id);
    console.log(this.clientiDaEliminare)
  }

  onPageChange(e: any) {
    console.log(e);
    this.clientiSvc.getPage(e.page, e.rows).subscribe(c => {
      this.clienti = c.content;
    });
  }

  onBlurEvent(cliente: ICliente) {
    this.clientiSvc.modificaCliente(cliente).subscribe(c => {
      console.log(c);
      this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Cliente modificato correttamente.' });
    });
  }

  clear(table: Table) {
    table.clear();
  }
}
