import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonModule } from 'primeng/button';
import { RegPageComponent } from './pages/reg-page/reg-page.component';
import { InputTextComponent } from './components/input-text/input-text.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LogPageComponent } from './pages/log-page/log-page.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ClientiTableComponent } from './pages/clienti-table/clienti-table.component';
import { TableModule } from 'primeng/table';
import { TokenInterceptorInterceptor } from './interceptors/token-interceptor.interceptor';
import { PaginatorModule } from 'primeng/paginator';
import { ToastModule } from 'primeng/toast';
import { ToastComponent } from './components/toast/toast.component';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [
    AppComponent,
    RegPageComponent,
    InputTextComponent,
    LogPageComponent,
    ClientiTableComponent,
    ToastComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    PasswordModule,
    BrowserAnimationsModule,
    HttpClientModule,
    TableModule,
    PaginatorModule,
    ToastModule
  ],
  providers: [
    /* {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorInterceptor,
      multi: true
    } */
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
