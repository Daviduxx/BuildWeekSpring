import { ICliente } from "./icliente";

export interface IFattura {
  id:number,
  data:Date,
  importo:number,
  stato:string,
  cliente:ICliente
}
