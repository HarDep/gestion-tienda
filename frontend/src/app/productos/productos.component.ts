import { Component } from '@angular/core';
import { ProductoVenta } from '../producto-venta';
import { VentasService } from '../ventas.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent {
  productos:ProductoVenta[];

  constructor(private ventaService:VentasService){}

  ngOnInit(): void{
    this.ventaService.getProductosEnStock().subscribe(data=>{
      this.productos = data;
    });
  }
}
