import { Component } from '@angular/core';
import { Compra } from '../compra';
import { ComprasService } from '../compras.service';
import { SujetosService } from '../sujetos.service';
import { Sujeto } from '../sujeto';
import { ProductoCompra } from '../producto-compra';
import { ProductosProveedor } from '../productos-proveedor';
import { Router } from '@angular/router';
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
  isError:boolean = false;
  messageError:String = '';

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
    console.log('idProveedor: ' + idProv)
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
      productoCompra.cantidad = 1;
      productoCompra.anioVencimiento = -1;
      productoCompra.mesVencimiento = -1;
      productoCompra.diaVencimiento = -1;
      this.compra.productos.push(productoCompra);
    }
  }

  cambiarFecha(item:ProductoCompra, event : Event){
    let elm: HTMLSelectElement = event.target as HTMLSelectElement;
    let fec = elm.value;
    item.anioVencimiento = Number.parseInt(fec.split('-')[0]);
    item.mesVencimiento = Number.parseInt(fec.split('-')[1]);
    item.diaVencimiento = Number.parseInt(fec.split('-')[2]);
    console.log(item.anioVencimiento+'/'+item.mesVencimiento+'/'+item.diaVencimiento);
  }

  guardarIdLote(event: any) {
    var idLoteSaved = event.target.value;
    this.idLote = idLoteSaved;
  }
  guardarIdProveedor(event: any) {
    var idSujetoSaved = event.target.value;
    this.idProveedor = idSujetoSaved;
    this.mostrarProductos(this.idProveedor);
  }

  guardarCompra() {
    this.compraService.saveCompra(this.compra, this.idLote, this.idProveedor).subscribe({next: data =>{
      console.log(data);
      this.isError = false;
      alert('Se guardo la venta correctamente');
      this.router.navigate(['productos'])
    }, error: e => {
      this.isError = true;
      this.messageError = e.error.message;
    }});
  }

  eliminarProd(cod:String){
    let index:number = this.compra.productos.findIndex(prod => prod.codigo === cod);
    this.compra.productos.splice(index,1);
  }

  quitarUno(prod:ProductoCompra){
    prod.cantidad--;
    if(prod.cantidad === 0){
      this.eliminarProd(prod.codigo);
    }
  }
}
