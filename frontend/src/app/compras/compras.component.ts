import { Component } from '@angular/core';
import { Compra } from '../compra';
import { ComprasService } from '../compras.service';
import { SujetosService } from '../sujetos.service';
import { Sujeto } from '../sujeto';
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
  
  constructor(private compraService:ComprasService,private sujetoService:SujetosService){ }

  ngOnInit(): void{
    this.compraService.getLotes().subscribe(data => {
      this.lotes = data;
    });
    this.sujetoService.getProveedores().subscribe(data => {
      this.proveedores = data;
    });
  }

  guardarCompra(){
    this.compraService.saveCompra(this.compra,this.idLote,this.idProveedor).subscribe(data=>{
      console.log(data);
    });
  }

}
