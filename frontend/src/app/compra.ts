import { Lote } from "./lote";
import { ProductoCompra } from "./producto-compra";
import { Sujeto } from "./sujeto";

export class Compra {
    id:number;
    lote:Lote;
    proveedor:Sujeto;
    fecha:Date;
    productos:ProductoCompra[];
}
