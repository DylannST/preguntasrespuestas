import { DatosRetoService } from './datos-reto.service';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TestSofkaService {
  categoriaActual: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  preguntaActual: BehaviorSubject<any[]> = new BehaviorSubject<any[]>([]);
  constructor(private data: DatosRetoService) {}

  guardarCategoria(categoria: any[]) {
    this.categoriaActual.next(categoria);
  }

  obtenerCambioCategoria() {
    return this.categoriaActual.asObservable();
  }

  guardarPregunta(pregunta: any[]) {
    this.preguntaActual.next(pregunta);
  }

  obtenerCambioPregunta() {
    return this.preguntaActual.asObservable();
  }

  guardarConfiguracionJuego(opciones: any[]) {
    this.data
      .guardarCategoria(this.categoriaActual.getValue())
      .subscribe((val) => {
        this.data
          .guardarPregunta(val, this.preguntaActual.getValue())
          .subscribe((pre) => {
            this.data.guardarOpciones(pre,opciones);
          });
      });
  }
}
