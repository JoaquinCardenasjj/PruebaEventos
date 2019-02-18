import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DepartamentoListComponent } from './departamento-list/departamento-list.component';
import { CreateDepartamentoComponent } from './create-departamento/create-departamento.component';

 
const routes: Routes = [
    { path: '', redirectTo: 'Departamento', pathMatch: 'full' },
    { path: 'Departamento', component: DepartamentoListComponent },
    { path: 'Agregar', component: CreateDepartamentoComponent },
    
];
 
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
 
export class AppRoutingModule { }