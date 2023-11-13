import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sujeto } from './sujeto';

@Injectable({
  providedIn: 'root'
})
export class SujetosService {

  url: String = '';

  constructor(private httpClient: HttpClient) {
    this.url = environment.urlSujetos;
  }

  getClientes(): Observable<Sujeto[]> {
    return this.httpClient.get<Sujeto[]>(`${this.url}/clientes`);
  }

  getEmpleados(): Observable<Sujeto[]> {
    return this.httpClient.get<Sujeto[]>(`${this.url}/empleados`);
  }

  getProveedores(): Observable<Sujeto[]> {
    return this.httpClient.get<Sujeto[]>(`${this.url}/proveedores`);
  }
}
