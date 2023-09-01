import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { ICliente } from 'src/app/models/icliente';
import { Page } from 'src/app/models/page';
import { ClientiService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-clienti-table',
  templateUrl: './clienti-table.component.html',
  styleUrls: ['./clienti-table.component.scss']
})
export class ClientiTableComponent implements OnInit {

  protected clienti:ICliente[]=[];
  loading: boolean = true;
  protected page:Page={
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

  constructor(private clientiSvc:ClientiService){
    clientiSvc.getPage(0, 10).subscribe(c=>{
      this.page=c;
      this.clienti=c.content;
      console.log(c);
      console.log(this.clienti);
      this.loading=false;
    });
  }

  ngOnInit() {

  }

  onPageChange(e:any){
    console.log(e);
    this.clientiSvc.getPage(e.page, e.rows).subscribe(c=>{
      this.clienti=c.content;
    });
  }

  clear(table: Table) {
    table.clear();
  }
}
