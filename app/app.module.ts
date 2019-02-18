import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateDepartamentoComponent } from './create-departamento/create-departamento.component';
import { DepartamentoDetailsComponent } from './departamento-details/departamento-details.component';
import { DepartamentoListComponent } from './departamento-list/departamento-list.component';
import { SearchDepartamentoComponent } from './search-departamento/search-departamento.component';
import { DepartamentoService } from './departamento.service';

// import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { DepartamentoUpdateComponent } from './departamento-update/departamento-update.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateDepartamentoComponent,
    DepartamentoDetailsComponent,
    DepartamentoListComponent,
    SearchDepartamentoComponent,
    DepartamentoUpdateComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [DepartamentoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
