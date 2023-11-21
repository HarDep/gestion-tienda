import { Municipio } from "./municipio";

export class Sujeto {
    idSujeto:number;
    tipoSujeto:String;//enum o string?
    municipio:Municipio; 
    nombre:String;
    apellido:String;
    telefono:String;
    direccion:String; 
    numeroDoc:String; 
    nit:String;
}