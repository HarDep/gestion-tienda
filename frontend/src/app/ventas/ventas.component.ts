import { Component } from '@angular/core';
import { Venta } from '../venta';
import { VentasService } from '../ventas.service';
import { SujetosService } from '../sujetos.service';
import { Sujeto } from '../sujeto';
import { ProductoVenta } from '../producto-venta';
import { Route, Router } from '@angular/router';
import { Lote } from '../lote';
import { ProductosProveedor } from "../productos-proveedor";

@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent {

  venta: Venta = new Venta();
  empleados: Sujeto[];
  clientes: Sujeto[];
  lotes: ProductoVenta[];
  idLote: number;
  idEmpleado: number;
  idCliente: number;
  stock: ProductoVenta[];
  botonDeshabilitado = true;
  private productos: ProductoVenta[];

  constructor(
    private ventaService: VentasService,
    private sujetoService: SujetosService,
    private router: Router) {}

  ngOnInit(): void {
    this.ventaService.getProductosEnStock().subscribe(data => {
      this.stock = data; // Inicializa el stock en la carga inicial
    });
    this.sujetoService.getEmpleados().subscribe(data => {
      this.empleados = data;
    });
    this.sujetoService.getClientes().subscribe(data => {
      this.clientes = data;
    });
  }

  mostrarStock(idCli: number): void {
    this.idCliente = idCli;

    this.ventaService.getProductosEnStock().subscribe((data => {
       this.stock = data;
    }))
  }

  guardarProducto(idPrueba: string) {
    let idk = this.productos[parseInt(idPrueba)]
    this.venta.productos.push()
    this.botonDeshabilitado = false;
  }

  guardarIdEmpleado(event: any) {
    this.idEmpleado = parseInt(event.target.value, 10);
  }

  guardarIdCliente(event: any) {
    this.idCliente = parseInt(event.target.value, 10);
    this.mostrarStock(this.idCliente);
  }

  guardarVenta() {
    this.ventaService.saveVenta(this.venta, this.idLote, this.idEmpleado, this.idCliente).subscribe(data => {
      console.log(data);
    });
    this.router.navigate(['productos'])
  }
}
