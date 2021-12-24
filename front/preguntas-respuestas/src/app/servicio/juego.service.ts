import { BehaviorSubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class JuegoService {
  idJuego: any;
  idJugador: any;
  historial:any
  jugador: BehaviorSubject<any> = new BehaviorSubject<any>({});
  seRegistra: BehaviorSubject<any> = new BehaviorSubject<any>({});

  constructor() {}

  obtenerJugadorActual() {
    return this.jugador.asObservable();
  }

  guardarJugador(jugador: any) {
    this.jugador.next(jugador);
    this.idJugador = jugador.idJugador;
  }
  obtenerRegistra() {
    return this.jugador.asObservable();
  }

  guardarRegistra(estado: {}) {
    this.seRegistra.next(estado);
  }
  agregarHistory(obj:any){
    this.historial=obj
  }
}
