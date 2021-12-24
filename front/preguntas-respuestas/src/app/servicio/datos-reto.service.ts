import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../interface/categoria';

@Injectable({
  providedIn: 'root',
})
export class DatosRetoService {
  private url = 'http://localhost:8080/';
  private header = {
    'Content-Type': 'application/json',
    'Acces-Control-Allow-Credentials': 'true',
  };

  constructor(private http: HttpClient) {}

  getDificultad(): Observable<string[]> {
    return this.http.get<string[]>(`${this.url}api/dificultad`);
  }

  guardarCategoria(categoria: any[]): Observable<any[]> {
    let listObj: any[] = [];
    categoria.forEach((cate) => {
      let obj = {
        descripcion: cate.descrip,
        dificultad: cate.dificultad,
      };
      listObj.push(obj);
    });

    return this.http.post<any[]>(
      `${this.url}api/categoria`,
      JSON.stringify(listObj),
      {
        headers: this.header,
      }
    );
  }

  guardarPregunta(categoria: any[], pregunta: any[]): Observable<any> {
    let listPregunta: any[] = [];
    pregunta.forEach((val) => {
      let obj = {
        descripcion: val.descrip,
        categoria: {
          idCategoria: categoria[0].idCategoria,
        },
      };
      listPregunta.push(obj);
    });

    return this.http.post(
      `${this.url}api/pregunta`,
      JSON.stringify(listPregunta),
      {
        headers: this.header,
      }
    );
  }

  guardarOpciones(pre: any[], preguntaOp: any[]) {
    preguntaOp.forEach((val) => {
      pre.forEach((pregun) => {
        if (pregun.descripcion === val.pregunta) {
          let listOpciones: any[] = [];
          val.respuestas.forEach((op: any) => {
            let obj = {
              descripcion: op.texto,
              esVerdadero: op.esVerdadero,
              pregunta: {
                idPregunta: pregun.idPregunta,
              },
            };
            listOpciones.push(obj);
          });
          this.http
            .post(`${this.url}api/opcion`, JSON.stringify(listOpciones), {
              headers: this.header,
            })
            .subscribe((pre) => {
              console.log(pre);
            });
        }
      });
    });
  }
  obtenerFormPreguntas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.url}api/pregunta/form`);
  }

  guardarPremio(puntos: any): Observable<any> {
    let obj = {
      puntos,
    };
    return this.http.post(`${this.url}api/premio`, obj, {
      headers: this.header,
    });
  }

  guardarRonda(obj: any) {
    console.log('objeto::::', obj);
    this.http.post(`${this.url}api/ronda`, obj, { headers: this.header });
  }

  obtenerPreguntasConDif(): Observable<any[]> {
    return this.http.get<any[]>(`${this.url}api/pregunta/dificultad`);
  }

  registrarJugador(jugador: any): Observable<any> {
    return this.http.post(`${this.url}api/jugador`, jugador, {
      headers: this.header,
    });
  }

  registrarJuego(obj: any): Observable<any> {
    return this.http.post(`${this.url}api/juego`, obj, {
      headers: this.header,
    });
  }
  registrarAcum(obj: any):Observable<any> {
    return this.http.post(`${this.url}api/acumulado`, obj, { headers: this.header });
  }
}
