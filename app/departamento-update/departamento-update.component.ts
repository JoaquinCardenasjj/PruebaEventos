import { Component, OnInit } from '@angular/core';
 
import { Departamento } from '../departamento';
import { DepartamentoService } from '../departamento.service';
 
@Component({
  selector: 'departamento-update',
  templateUrl: './departamento-update.component.html',
  styleUrls: ['./departamento-update.component.css']
})
export class DepartamentoUpdateComponent implements OnInit {
 
  departamento: Departamento = new Departamento();
  submitted = false;
 
  constructor(private departamentoService: DepartamentoService) { }
 
  ngOnInit() {
  }
 
  newdepartamento(): void {
    this.submitted = false;
    this.departamento = new Departamento();
  }
 
  update() {
    this.departamentoService.updateDepartamento(this.departamento.id, this.departamento.nombre)
      .subscribe(data => console.log(data), error => console.log(error));
    this.departamento = new Departamento();
  }
 
  onSubmit() {
    this.submitted = true;
    this.update();
  }
}