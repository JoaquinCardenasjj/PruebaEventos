import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponet}from './footer/footer.componet';
import { DepartamentoComponent } from './departamento/departamento.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FormComponent } from './departamento/form.component';

const routes: Routes = [
  // { path: '', redirectTo: '/departamento', pathMatch: 'full' },
  { path: 'departamento', component:DepartamentoComponent,pathMatch: 'full' },
  { path: 'departamento/form', component: FormComponent,pathMatch: 'full' }
  
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponet,
    DepartamentoComponent,
    FormComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
