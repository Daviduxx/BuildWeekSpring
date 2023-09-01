import { IFattura } from "./ifattura";
import { IIndirizzo } from "./iindirizzo";

export interface ICliente {
  id:number,
  ragioneSociale:string,
  partitaIva:string,
  email:string,
  dataInserimento:Date,
  dataUltimoContatto:Date,
  fatturatoAnnuale:number,
  pec:string,
  telefono:string,
  emailContatto:string,
  nomeContatto:string,
  cognomeContatto:string,
  telefonoContatto:string,
  tipoCliente:string,
  indirizzoSedi:IIndirizzo[],
  fatture: IFattura[]
}
