import { Component} from '@angular/core';
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

  tipoSujeto: number;

  townSelected: number;
  typeSujeto: number;
  isError:boolean = false;
  messageError:String = '';

  //general -> tipo, nombre, municipio, telefono, direccion
  //persona -> tipo, nombre, apellido, documento, municipio, telefono, direccion
  //empresa -> tipo, nombre, municipio, telefono, direccion, nit

  regexDigits = /^(?!.*\s{2})[a-zA-Z0-9\s]+$/;
  regexSpaces = /^[a-zA-Z0-9]+$/;

  constructor(
    private clienteService: SujetosService,
    ) { }


  getCliente() {
    this.clienteService.getClientes().subscribe(data => {
      this.clientes = data;
      let index: number = this.clientes.findIndex(cli => cli.tipoSujeto === 'MEE');
      if(index !== -1){
        this.clientes.splice(index,1);
      }
    })
  }

  ngOnInit(): void {
    this.getCliente()

    this.clienteService.getMunicipios().subscribe(data => {
      this.municipios = data
    })
  }

  editAddCustomer(customer?: Sujeto) {
    this.inEdit = customer ? true: false;
    if (this.inEdit) {
      let index: number = this.clientes.findIndex(cus => cus.idSujeto === customer.idSujeto);
      this.objToBeChanged = this.clientes[index];
    }
    this.changeCustomers = true;
  }

  removeCustomer(idSujeto: number) {
    this.clienteService.deleteSujeto(idSujeto).subscribe({next: data =>{
        console.log(data);
        this.isError = false;
        this.getCliente();
        this.messageError = '';
      }, error: e => {
        if(e.status === 200){
          this.isError = false;
          this.getCliente();
          this.messageError = '';
        } else{
          this.isError = true;
          this.messageError = e.error.message;
        }
      }});
  }

  saveEditCustomer(customer: Sujeto) {
    this.clienteService.updateSujeto(this.tipoSujeto, this.townSelected, customer.idSujeto, customer).subscribe({next: data =>{
      console.log(data);
      this.isError = false;
      this.getCliente();
      this.messageError = '';
    }, error: e => {
      this.isError = true;
      this.messageError = e.error.message;
    }});
  }

  saveNewCustomer(customer: Sujeto) {
    this.clienteService.saveSujeto(this.tipoSujeto, this.townSelected, customer).subscribe({next: data =>{
      console.log(data);
      this.isError = false;
      this.getCliente();
      this.messageError = '';
    }, error: e => {
      this.isError = true;
      this.messageError = e.error.message;
    }});
  }

  personType(event: any) {
    this.tipoSujeto = Number.parseInt(event.target.value)
  }

  setTownSelected(event: any) {
    this.townSelected = event.target.value;
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
}
