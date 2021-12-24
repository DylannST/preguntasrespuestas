import { Categoria } from './../interface/categoria';
import { JuegoService } from './../servicio/juego.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DatosRetoService } from '../servicio/datos-reto.service';

@Component({
  selector: 'app-pregunta-respuesta',
  templateUrl: './pregunta-respuesta.component.html',
  styleUrls: ['./pregunta-respuesta.component.css'],
})
export class PreguntaRespuestaComponent implements OnInit {
  acum = 0;
  respuesta: any;
  numPreguntaAleatoria = 0 /*Math.floor(Math.random() * (3 - 0)) + 0*/;
  estadoBarra = `width: ${20}%`;
  sum = 20;
  pag = 0;
  estadoJuador: boolean = false;
  actual: {} = {};
  listFormPreguntas: any[] = [];
  @Output() estado = new EventEmitter<boolean>();
  constructor(
    private apiEstado: JuegoService,
    private data: DatosRetoService
  ) {}

  ngOnInit(): void {
    this.apiEstado.obtenerJugadorActual().subscribe((val) => {
      if (val.nombre !== undefined) {
        this.estadoJuador = true;
        this.obtenerPregunRespu();
      }
    });
  }

  obtenerPregunRespu() {
    let listForm: any[] = [];
    this.data.obtenerFormPreguntas().subscribe((value) => {
      let form = {
        nombre: '',
        nivel: 0,
        preguntas: [
          {
            pregunta: '',
            opciones: [{ tex: '', esVerda: false }],
          },
        ],
      };

      value.forEach((val) => {
        let [pregunta, respuesta, esVe, catego, nivel] = val;

        if (listForm.length !== 0 && this.existeCatego(listForm, catego)) {
          listForm.map((obj: any) => {
            if (obj.nombre === catego) {
              if (
                obj.preguntas.length !== 0 &&
                this.existePre(listForm, pregunta)
              ) {
                obj.preguntas.forEach((pre: any) => {
                  if (pre.pregunta === pregunta) {
                    pre.opciones.push({ tex: respuesta, esVerda: esVe });
                  }
                });
              } else {
                listForm.forEach((val) => {
                  if (val.nombre === catego) {
                    val.preguntas.push({
                      pregunta,
                      opciones: [{ tex: respuesta, esVerda: esVe }],
                    });
                  }
                });
              }
            }
          });
        } else {
          listForm.push({
            nombre: catego,
            nivel: nivel,
            real: true,
            preguntas: [
              {
                pregunta,
                opciones: [{ tex: respuesta, esVerda: esVe }],
              },
            ],
          });
        }
      });
    });
    console.log(listForm);
    this.listFormPreguntas = listForm;

    let listPremios: any[] = [];
    let listPuntajes: number[] = [];
    let listNieveles: number[] = [];
    let listId: any[] = [];
    listForm.forEach((x) => {
      listNieveles.push(x.nivel);
    });

    listForm.forEach((cate) => {
      this.data.guardarPremio(cate.nivel * 5).subscribe((val: any) => {
        listPremios.push(val);
      });
      listPremios.forEach((op) => {
        listPuntajes.push(op.puntos);
      });
      listNieveles.sort((a, b) => {
        return a - b;
      });
      listPuntajes.sort((a, b) => {
        return a - b;
      });

      this.data.obtenerPreguntasConDif().subscribe((idNuevo) => {
        let [idPregunta, nivel] = idNuevo;
        let obj = {
          idPregunta,
          nivel,
        };
        listId.push(obj);
      });
      console.log(listPuntajes);
      listPuntajes.forEach((num) => {
        listPremios.forEach((prem) => {
          if (prem.puntos === num) {
            listNieveles.forEach((nil) => {
              listId.forEach((ids) => {
                if (ids.nivel === nil) {
                  let obj = {
                    premio: {
                      idPremio: prem.idPremio,
                    },
                    juego: {
                      idJuego: this.apiEstado.idJuego,
                    },
                    pregunta: {
                      idPregunta: ids.idPregunta,
                    },
                  };
                  this.data.guardarRonda(obj);
                }
              });
            });
          }
        });
      });
    });
  }

  existeCatego(lista: any[], catego: any): boolean {
    let paso = false;
    if (lista.length !== 0) {
      lista.forEach((val) => {
        if (val.nombre === catego) {
          paso = true;
        }
      });
    }
    return paso;
  }
  existePre(lista: any[], pregunta: any) {
    let paso = false;
    if (lista.length !== 0) {
      lista.forEach((val) => {
        val.preguntas.forEach((pre: any) => {
          if (pre.pregunta === pregunta) {
            paso = true;
          }
        });
      });
    }
    return paso;
  }

  siguiente() {
    this.pag++;
    this.sum = this.sum + 20;
    this.estadoBarra = `width: ${this.sum}%`;
    this.numPreguntaAleatoria = 0;
    if (this.respuesta.esco) {
      this.acum = this.acum + this.respuesta.nivel + 1;
    } else {
      alert('Perdiste :C');
      this.estado.emit(false);
      this.acum = 0;
    }

    if (this.respuesta.nivel == 4) {
      alert('Ganaste el Juego!!!');
      let ob = {
        total: this.acum,
        jugador: {
          idJugador: this.apiEstado.idJugador,
        },
      };
      this.data.registrarAcum(ob).subscribe((val) => {
        console.log(val);
        let objT = {
          id: val.jugador.idJugador,
          total: val.total,
        };
        this.apiEstado.agregarHistory(objT);
      });
      this.estado.emit(false);
    }
  }
  abandonar() {
    let op = confirm(
      '¿Está seguro de abandonar? Perdera sus puntos acumulados'
    );
    if (op) {
      this.estado.emit(false);
    }
  }

  menorNivel() {
    let menor = 4;
    this.listFormPreguntas.forEach((x) => {
      if (x.realizado) {
        if (x.nivel < menor) {
          menor = x.nivel;
        }
      }
    });
    return menor;
  }

  cambioEstado(estadoForm: any, nivel: number) {
    this.respuesta = {
      esco: estadoForm,
      nivel,
    };
  }
}
