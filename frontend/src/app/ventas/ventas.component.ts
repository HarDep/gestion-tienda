import { Component } from '@angular/core';
import { Venta } from '../venta';
import { Sujeto } from '../sujeto';
import { SujetosService } from '../sujetos.service';
import { VentasService } from '../ventas.service';
import { ProductoVenta } from '../producto-venta';

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

  constructor(private sujetoService:SujetosService, private ventaService:VentasService){}

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
  }

  guardarVenta(){
    this.ventaService.saveVenta(this.venta,this.idCliente,this.idEpleado).subscribe(data=>{
      console.log(data);
    });
  }

}
