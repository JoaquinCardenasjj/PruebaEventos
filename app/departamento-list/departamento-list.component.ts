import { Component, OnInit } from '@angular/core';
import { DepartamentoService } from '../departamento.service';
import { Departamento } from '../departamento';
import { Observable } from "rxjs";

@Component({
  selector: 'departamento-list',
  templateUrl: './departamento-list.component.html',
  styleUrls: ['./departamento-list.component.css']
})
export class DepartamentoListComponent implements OnInit {
 
  departamentos: Observable<Departamento[]>;
 
  constructor(private departamentoService: DepartamentoService) { }
 
  ngOnInit() {
    this.reloadData();
  }
 
  deletedepartamentos() {
    this.departamentoService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }
 
  reloadData() {
    this.departamentos = this.departamentoService.getDepartamentosList();
  }
  onDelete(Departamento) {
    if(confirm('Are you sure you want to delete it?')) {
      this.departamentoService.deleteDepartamento(Departamento.id);
      // this.toastr.warning('Deleted Successfully', 'Product Removed');
    }
  }
}