import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Municipio } from 'app/municipio';
import { Sujeto } from 'app/sujeto';
import { SujetosService } from 'app/sujetos.service';

@Component({
  selector: 'app-sujetos',
  templateUrl: './sujetos.component.html',
  styleUrls: ['./sujetos.component.css'],
})

export class SujetosComponent {

  clientes: Sujeto[];
  municipios: Municipio[]
  ventanaVisible = false;
  objToBeChanged: Sujeto = new Sujeto();
  changeCustomers: boolean = false
  inEdit = false;

  tipoSujeto: number = 1;

  townSelected: Municipio;
  typeSujeto: number;

  //general -> tipo, nombre, municipio, telefono, direccion
  //persona -> tipo, nombre, apellido, documento, municipio, telefono, direccion
  //empresa -> tipo, nombre, municipio, telefono, direccion, nit

  regexDigits = /^(?!.*\s{2})[a-zA-Z0-9\s]+$/;
  regexSpaces = /^[a-zA-Z0-9]+$/;

  constructor(
    private clienteService: SujetosService,
    private router: Router) { }


  getCliente() {
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data
    })
  }

  ngOnInit(): void {
    this.getCliente()

    this.clienteService.getMunicipios().subscribe(data => {
      this.municipios = data
    })
  }

  editAddCustomer(customer?: Sujeto) {
    this.inEdit = customer != null
    if (this.inEdit) {
      let index: number = this.clientes.findIndex(cus => cus.idSujeto == customer.idSujeto)
      this.objToBeChanged = this.clientes[index]
    }
    this.changeCustomers = true
  }

  removeCustomer(idSujeto: number) {
    try{
      this.clienteService.deleteSujeto(idSujeto).subscribe(data => {
        console.log('delete/data: ' + data)
        this.getCliente()
        alert("Accion realizada")
      })
    }catch(error){
      alert(error.data.message)
    }
    location.reload()
  }

  saveEditCustomer(customer: Sujeto) {
    try {
      this.clienteService.updateSujeto(this.tipoSujeto, this.townSelected.id, customer.idSujeto, customer).subscribe(data => {
        console.log('edit/data: ' + data)
        this.getCliente()
        alert("Accion realizada")
      })
    } catch (error) {
      alert(error.data.message)
    }
  }

  saveNewCustomer(customer: Sujeto) {
    try {
      this.clienteService.saveSujeto(this.tipoSujeto, this.townSelected.id, customer).subscribe(data => {
        console.log('new/data: ' + data)
        this.getCliente()
        alert("Accion realizada")
      })
    } catch (error) {
      alert(error.data.message)
    }
  }

  searchTown(nameTown: string): Municipio {
    let town = new Municipio()
    for (let i = 0; i < this.municipios.length; i++) {
      if (this.municipios[i].nombre === nameTown) {
        town = this.municipios[i]
        break;
      }
    }
    return town;
  }

  personType(event: any) {
    this.tipoSujeto = Number.parseInt(event.target.value)
  }

  setTownSelected(event: any) {
    this.townSelected = this.searchTown(event.target.value)
  }

  saveChanges() {
    if (this.inEdit) {
      this.saveEditCustomer(this.objToBeChanged)
    } else {
      this.saveNewCustomer(this.objToBeChanged)
    }
    this.clearInputs()
  }

  clearInputs() {
    this.changeCustomers = false
    this.objToBeChanged = new Sujeto()
  }
  /*
  this.compraService.getLotes().subscribe(data => {
      this.lotes = data;
    });
  */
}
