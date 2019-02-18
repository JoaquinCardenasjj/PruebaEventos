import { Component, OnInit } from '@angular/core';
 
import { Departamento } from '../departamento';
import { DepartamentoService } from '../departamento.service';
 
@Component({
  selector: 'create-departamento',
  templateUrl: './create-departamento.component.html',
  styleUrls: ['./create-departamento.component.css']
})
export class CreateDepartamentoComponent implements OnInit {
 
  departamento: Departamento = new Departamento();
  submitted = false;
 
  constructor(private departamentoService: DepartamentoService) { }
 
  ngOnInit() {
  }
 
  newdepartamento(): void {
    this.submitted = false;
    this.departamento = new Departamento();
  }
 
  save() {
    this.departamentoService.createDepartamento(this.departamento)
      .subscribe(data => console.log(data), error => console.log(error));
    this.departamento = new Departamento();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }
}