import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ProductoVenta } from './producto-venta';
import { Venta } from './venta';

@Injectable({
  providedIn: 'root'
})
export class VentasService {

  url: String = '';

  constructor(private httpClient: HttpClient) {
    this.url = environment.urlVentas;
  }

  getProductosEnStock(): Observable<ProductoVenta[]> {
    return this.httpClient.get<ProductoVenta[]>(`${this.url}/productos/stock`);
  }

  saveVenta(venta: Venta, idCliente: number, idEmpleado: number, number: number): Observable<Venta> {
    return this.httpClient.post<Venta>(`${this.url}?idCliente=${idCliente}&idEmpleado=${idEmpleado}`, venta);
  }
}
