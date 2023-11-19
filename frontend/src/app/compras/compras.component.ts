import { Component } from '@angular/core';
import { Compra } from '../compra';
import { ComprasService } from '../compras.service';
import { SujetosService } from '../sujetos.service';
import { Sujeto } from '../sujeto';
import { ProductoCompra } from '../producto-compra';
import { ProductosProveedor } from '../productos-proveedor';
import { Route, Router } from '@angular/router';
import { Lote } from '../lote';

@Component({
  selector: 'app-compras',
  templateUrl: './compras.component.html',
  styleUrls: ['./compras.component.css']
})
export class ComprasComponent {

  compra:Compra = new Compra();
  proveedores:Sujeto[];
  lotes:Lote[];
  idLote:number;
  idProveedor:number;
  productos: ProductosProveedor[];

  botonDeshabilitado = true;


  constructor(
    private compraService:ComprasService,
    private sujetoService:SujetosService,
    private router:Router){}

  ngOnInit(): void{
    this.compraService.getLotes().subscribe(data => {
      this.lotes = data;
    });
    this.sujetoService.getProveedores().subscribe(data => {
      this.proveedores = data;
    });
  }

  mostrarProductos(idProv: number):void{
    this.idProveedor = idProv;

    this.compraService.getProductosProveedor(idProv).subscribe((data =>{
      this.productos = data;
    }))
  }

  guardarProducto(idPrueba: string){
    let idk = this.productos[parseInt(idPrueba)]
    this.compra.productos.push()
    this.botonDeshabilitado = false;
  }

  guardarIdLote(event: any){
    this.idLote = parseInt(event.target.value, 10);
  }
  guardarIdProveedor(event: any){
    this.idProveedor = parseInt(event.target.value, 10);
  }

  guardarCompra(){
    this.compraService.saveCompra(this.compra,this.idLote,this.idProveedor).subscribe(data=>{
      console.log(data);
    });
    this.router.navigate(['productos'])
  }
}
