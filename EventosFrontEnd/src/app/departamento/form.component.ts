import { Component, OnInit } from '@angular/core';
import { Departamento } from './departamento';

@Component({
  selector: 'app-form-departamento',
  templateUrl: './form.component.html',  
})
export class FormComponent implements OnInit {

  private departamento :Departamento = new Departamento()
  private titulo:string = "Crear cliente"
  constructor() { }

  ngOnInit() {
  }
  public crear():void{
    console.log("Clicked!")
    console.log(this.departamento)

  }

}
