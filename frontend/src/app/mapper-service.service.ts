import { Injectable } from '@angular/core';
import { ProductosProveedor } from './productos-proveedor';
import { ProductoCompra } from './producto-compra';

@Injectable({
  providedIn: 'root'
})
export class MapperServiceService {

  castProductProvACompra(producto: ProductosProveedor): ProductoCompra{
    let productoCompra = new ProductoCompra()

    productoCompra.codigo = producto.codigoProducto;
    productoCompra.nombre = producto.nombreProducto
    productoCompra.descripcion = producto.descripcionProducto
    productoCompra.precio = producto.precio
    productoCompra.cantidad = 0
    productoCompra.categoria = producto.categoriaProducto

    return productoCompra
  }

  constructor() { }
}
