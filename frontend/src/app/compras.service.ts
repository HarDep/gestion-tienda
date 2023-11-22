import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Lote } from './lote';
import { ProductosProveedor } from './productos-proveedor';
import { Compra } from './compra';

@Injectable({
  providedIn: 'root'
})
export class ComprasService {

  url: String = '';

  constructor(private httpClient: HttpClient) {
    this.url = environment.urlcompras;
  }

  getLotes(): Observable<Lote[]> {
    return this.httpClient.get<Lote[]>(`${this.url}/lotes`);
  }

  getProductosProveedor(idProveedor:number): Observable<ProductosProveedor[]> {
    return this.httpClient.get<ProductosProveedor[]>(`${this.url}/proveedor/${idProveedor}/productos`);
  } 

  saveCompra(compra:Compra, idLote:number, idProveedor:number): Observable<Compra> {
    return this.httpClient.post<Compra>(`${this.url}?idLote=${idLote}&idProveedor=${idProveedor}`,compra);
  }
  
}
