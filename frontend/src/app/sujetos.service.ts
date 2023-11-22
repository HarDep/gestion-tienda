import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable, catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sujeto } from './sujeto';
import { Municipio } from './municipio';

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

  saveSujeto(tipoSujeto: number, idMunicipio: number, sujeto: Sujeto): Observable<Sujeto>{
    return this.httpClient.post<Sujeto>(`${this.url}?idMunicipio=${idMunicipio}&tipo=${tipoSujeto}`,sujeto);
  }

  updateSujeto(tipoSujeto: number, idMunicipio: number, idSujeto: number, sujeto: Sujeto): Observable<Sujeto>{
    return this.httpClient.put<Sujeto>(`${this.url}?idSujeto=${idSujeto}&idMunicipio=${idMunicipio}&tipo=${tipoSujeto}`,sujeto);
  }

  deleteSujeto(idSujeto: number): Observable<string>{
    return this.httpClient.delete<string>(`${this.url}/${idSujeto}`);
  }

  getMunicipios(): Observable<Municipio[]>{
    return this.httpClient.get<Municipio[]>(`${this.url}/municipios`);
  }
}
