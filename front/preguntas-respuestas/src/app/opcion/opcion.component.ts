import { FormGroup, FormControl } from '@angular/forms';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { TestSofkaService } from '../servicio/test-sofka.service';

@Component({
  selector: 'app-opcion',
  templateUrl: './opcion.component.html',
  styleUrls: ['./opcion.component.css'],
})
export class OpcionComponent implements OnInit {
  pregunta: any[] = [];
  opcion: any[] = [];
  formOpciones: FormGroup;

  @Output() estado = new EventEmitter<boolean>();

  constructor(private apiEstado: TestSofkaService) {
    this.formOpciones = new FormGroup({
      respuesta: new FormControl(['']),
      pregunta: new FormControl(['']),
    });
  }

  ngOnInit(): void {
    this.apiEstado.obtenerCambioPregunta().subscribe((value) => {
      this.pregunta = value;
    });
  }

  finalizar() {
    this.estado.emit(false);
    this.apiEstado.guardarConfiguracionJuego(this.opcion);
  }


  agregar() {
    if (this.opcion.length !== 0 && this.existe()) {
      this.opcion.forEach((obj) => {
        if (obj.pregunta === this.formOpciones.value.pregunta) {
          obj.respuestas.push({
            texto: this.formOpciones.value.respuesta,
            esVerdadero: false,
          });
        }
      });
    } else {
      this.agregarNuevaOpcion();
    }
    this.formOpciones.reset();
  }

  existe(): boolean {
    let estado = false;
    this.opcion.forEach((x) => {
      if (x.pregunta === this.formOpciones.value.pregunta) {
        estado = true;
      }
    });
    return estado;
  }

  agregarNuevaOpcion() {
    let nuevoObj = {
      pregunta: this.formOpciones.value.pregunta,
      respuestas: [
        { texto: this.formOpciones.value.respuesta, esVerdadero: false },
      ],
    };

    this.opcion = [...this.opcion, nuevoObj];
  }

  cambioEsVerdadero({ target: { checked } }: any, item: any, respuesta: any) {
    this.opcion.map((obj) => {
      if (obj.pregunta === item.pregunta) {
        obj.respuestas.map((x: any) => {
          if (x.esVerdadero) {
            x.esVerdadero = false;
          }
        });
      }
      if (obj.pregunta === item.pregunta) {
        obj.respuestas.map((x: any) => {
          if (x.texto === respuesta) {
            x.esVerdadero = true;
          }
        });
      }
    });
  }

  eliminar(item: any, respuesta: any) {
    let op = confirm('¿Esta seguro de eliminarlo?');
    if (op) {
      this.opcion.map((value) => {
        if (value.pregunta === item.pregunta) {
          value.respuestas = value.respuestas.filter(
            (x: any) => x.texto !== respuesta
          );
        }
      });
    }
  }
}
