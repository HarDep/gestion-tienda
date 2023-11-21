import { Component } from '@angular/core';
import { Compra } from '../compra';
import { ComprasService } from '../compras.service';
import { SujetosService } from '../sujetos.service';
import { Sujeto } from '../sujeto';
import { ProductoCompra } from '../producto-compra';
import { ProductosProveedor } from '../productos-proveedor';
import { Route, Router } from '@angular/router';
import { Lote } from '../lote';
import { MapperServiceService } from 'app/mapper-service.service';

@Component({
  selector: 'app-compras',
  templateUrl: './compras.component.html',
  styleUrls: ['./compras.component.css']
})
export class ComprasComponent {

  compra: Compra = new Compra();
  proveedores: Sujeto[];
  lotes: Lote[];
  idLote: number;
  idProveedor: number;
  productos: ProductosProveedor[];

  constructor(
    private compraService: ComprasService,
    private sujetoService: SujetosService,
    private mapperService: MapperServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.compra.productos = [];

    this.compraService.getLotes().subscribe(data => {
      this.lotes = data;
    });

    this.sujetoService.getProveedores().subscribe(data => {
      this.proveedores = data;
    });
  }

  mostrarProductos(idProv: number): void {
    this.compraService.getProductosProveedor(idProv).subscribe((data => {
      this.productos = data;
    }))
  }

  guardarProducto(producto: ProductosProveedor) {
    let done = false
    this.compra.productos.forEach((value) => {
      if (producto.codigoProducto === value.codigo) {
        value.cantidad++
        done = true
      }
    })
    if (!done) {
      let productoCompra: ProductoCompra = this.mapperService.castProductProvACompra(producto)
      this.compra.productos.push(productoCompra);
    }
  }

  guardarIdLote(event: any) {
    var idLoteSaved = event.target.value
    this.idLote = idLoteSaved;
  }
  guardarIdProveedor(event: any) {
    var idSujetoSaved: number = event.target.value
    this.mostrarProductos(idSujetoSaved)
    this.idProveedor = idSujetoSaved;
  }

  guardarCompra() {
    this.compraService.saveCompra(this.compra, this.idLote, this.idProveedor).subscribe(data => {
      console.log(data);
    });
    this.router.navigate(['productos'])
  }
}
