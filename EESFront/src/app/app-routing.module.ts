import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegPageComponent } from './pages/reg-page/reg-page.component';
import { LogPageComponent } from './pages/log-page/log-page.component';
import { ClientiTableComponent } from './pages/clienti-table/clienti-table.component';

const routes: Routes = [
  {path: "", component: RegPageComponent},
  {path: "login", component: LogPageComponent},
  {path: "clienti", component: ClientiTableComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
