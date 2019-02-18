import { Component, OnInit } from '@angular/core';
import { Departamento } from '../departamento';
import { DepartamentoService } from '../departamento.service';
 
@Component({
  selector: 'search-departamento',
  templateUrl: './search-departamento.component.html',
  styleUrls: ['./search-departamento.component.css']
})
export class SearchDepartamentoComponent implements OnInit {
 
  age: number;
  departamentos: Departamento[];
 
  constructor(private dataService: DepartamentoService) { }
 
  ngOnInit() {
    this.age = 0;
  }
 
  // private searchdepartamentos() {
  //   this.dataService.getDepartamento(this.age)
  //     .subscribe(departamentos => this.departamentos = departamentos);
  // }
 
  // onSubmit() {
  //   this.searchdepartamentos();
  // }
}