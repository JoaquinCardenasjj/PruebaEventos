import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {
 
  private baseUrl = 'http://localhost:8080/api/departamentos';
 
  constructor(private http: HttpClient) { }
 
  getDepartamento(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
 
  createDepartamento(Departamento: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, Departamento);
  }
 
  updateDepartamento(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
 
  deleteDepartamento(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 
  getDepartamentosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}