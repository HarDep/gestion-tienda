import { Component } from '@angular/core';
import { Venta } from '../venta';
import { Sujeto } from '../sujeto';
import { SujetosService } from '../sujetos.service';
import { VentasService } from '../ventas.service';
import { ProductoVenta } from '../producto-venta';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent {

  venta:Venta = new Venta();
  empleados:Sujeto[];
  clientes:Sujeto[];
  stock:ProductoVenta[];
  idCliente:number;
  idEpleado:number;
  isError:boolean = false;
  messageError:String = '';

  constructor(private sujetoService:SujetosService, private ventaService:VentasService,private router: Router){}

  ngOnInit(): void{
    this.sujetoService.getClientes().subscribe(data=>{
      this.clientes = data;
    });
    this.sujetoService.getEmpleados().subscribe(data=>{
      this.empleados = data;
    });
    this.ventaService.getProductosEnStock().subscribe(data=>{
      this.stock = data;
    });
    this.venta.productos = [];
  }

  guardarVenta(){
      this.ventaService.saveVenta(this.venta,this.idCliente,this.idEpleado).subscribe({next: data =>{
        console.log(data);
        this.isError = false;
        alert('Se guardo la venta correctamente');
        this.router.navigate(['productos'])
      }, error: e => {
        this.isError = true;
        this.messageError = e.error.message;
      }});
  }



  cambiarIdEmp(event : Event){
    let elm: HTMLSelectElement = event.target as HTMLSelectElement;
    this.idEpleado = elm.value as unknown as number;
  }

  cambiarIdCli(event : Event){
    let elm: HTMLSelectElement = event.target as HTMLSelectElement;
    this.idCliente = elm.value as unknown as number;
  }

  eliminarProd(cod:String){
    let index:number = this.venta.productos.findIndex(prod => prod.codigo === cod);
    let indxSt: number = this.stock.findIndex(prod => prod.codigo === cod);
    this.stock[indxSt].cantidad += this.venta.productos[index].cantidad;
    this.venta.productos.splice(index,1);
  }

  quitarUno(cod:String){
    let index:number = this.venta.productos.findIndex(prod => prod.codigo === cod);
    let product : ProductoVenta = this.venta.productos[index];
    product.cantidad --;
    let indxSt: number = this.stock.findIndex(prod => prod.codigo === cod);
    this.stock[indxSt].cantidad ++;
    if(product.cantidad === 0){
      this.venta.productos.splice(index, 1);
    }
  }

  addProducto(prod: ProductoVenta): void{
    let index:number = this.venta.productos.findIndex(prod => prod.codigo === prod.codigo);
    if(index === -1){
      let producto : ProductoVenta = new ProductoVenta();
      producto.nombre = prod.nombre;
      producto.codigo = prod.codigo;
      producto.precio = prod.precio;
      producto.cantidad = 1;
      prod.cantidad --;
      this.venta.productos.push(producto);
    } else{
      this.venta.productos[index].cantidad ++;
      prod.cantidad --;
    }
  }

}
