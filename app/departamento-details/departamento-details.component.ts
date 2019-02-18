import { Component, OnInit, Input } from '@angular/core';
import { DepartamentoService } from '../departamento.service';
import { Departamento } from '../departamento';
 
import { DepartamentoListComponent } from '../departamento-list/departamento-list.component';
 
@Component({
  selector: 'departamento-details',
  templateUrl: './departamento-details.component.html',
  styleUrls: ['./departamento-details.component.css']
})
export class DepartamentoDetailsComponent implements OnInit {
 
  @Input() Departamento: Departamento;
 
  constructor(private DepartamentoService: DepartamentoService, private listComponent: DepartamentoListComponent) { }
 
  ngOnInit() {
  }
 
  updateActive(isActive: boolean) {
    this.DepartamentoService.updateDepartamento(this.Departamento.id,
      { name: this.Departamento.nombre, })
      .subscribe(
        data => {
          console.log(data);
          this.Departamento = data as Departamento;
        },
        error => console.log(error));
  }
 
  deleteDepartamento() {
    this.DepartamentoService.deleteDepartamento(this.Departamento.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}