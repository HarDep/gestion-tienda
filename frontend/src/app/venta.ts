import { ProductoVenta } from "./producto-venta";
import { Sujeto } from "./sujeto";

export class Venta {
    id:number;
    cliente:Sujeto;
    empleado:Sujeto;
    fecha:Date;
    productos:ProductoVenta[];
    precioEntrega:number;
}
