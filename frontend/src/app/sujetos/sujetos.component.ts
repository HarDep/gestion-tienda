import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Sujeto } from 'app/sujeto';
import { SujetosService } from 'app/sujetos.service';

@Component({
  selector: 'app-sujetos',
  templateUrl: './sujetos.component.html',
  styleUrls: ['./sujetos.component.css']
})
export class SujetosComponent {

  clientes: Sujeto[];
  ventanaVisible = false;

  constructor(
    private clienteService: SujetosService,
    private router: Router) { }


  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data
    })

    this.clientes = []

    var cliente1 = new Sujeto()
    cliente1.idSujeto = 1
    cliente1.tipoSujeto = "cliente"
    cliente1.municipio = 'Tunja'
    cliente1.nombre = 'nombre1'
    cliente1.apellido = 'apellido1'
    cliente1.telefono = '12345'
    cliente1.direccion = 'calle 73a'
    cliente1.numeroDoc = '1234'
    this.clientes.push(cliente1)

    var cliente2 = new Sujeto()
    cliente2.idSujeto = 2
    cliente2.tipoSujeto = "cliente"
    cliente2.municipio = 'Tunja'
    cliente2.nombre = 'nombre2'
    cliente2.apellido = 'apellido2'
    cliente2.telefono = '12345'
    cliente2.direccion = 'calle 73a'
    cliente2.numeroDoc = '5678'
    this.clientes.push(cliente2)

    var cliente3 = new Sujeto()
    cliente3.idSujeto = 3
    cliente3.tipoSujeto = "cliente"
    cliente3.municipio = 'Tunja'
    cliente3.nombre = 'nombre3'
    cliente3.apellido = 'apellido3'
    cliente3.telefono = '12345'
    cliente3.direccion = 'calle 73a'
    cliente3.numeroDoc = '91011'
    this.clientes.push(cliente3)

    var cliente4 = new Sujeto()
    cliente4.idSujeto = 4
    cliente4.tipoSujeto = "cliente"
    cliente4.municipio = 'Tunja'
    cliente4.nombre = 'nombre4'
    cliente4.apellido = 'apellido4'
    cliente4.telefono = '12345'
    cliente4.direccion = 'calle 73a'
    cliente4.numeroDoc = '121314'
    this.clientes.push(cliente4)
  }

  removeCustomer(cliente: Sujeto){

  }

  editCustomer(cliente: Sujeto){

  }

  saveCustomer(cliente: Sujeto){

  }

  /*
  this.compraService.getLotes().subscribe(data => {
      this.lotes = data;
    });
  */
}
