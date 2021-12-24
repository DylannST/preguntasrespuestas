import { DatosRetoService } from './../servicio/datos-reto.service';
import { FormGroup, FormControl } from '@angular/forms';
import { JuegoService } from './../servicio/juego.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro-jugador',
  templateUrl: './registro-jugador.component.html',
  styleUrls: ['./registro-jugador.component.css'],
})
export class RegistroJugadorComponent implements OnInit {
  formJugador: FormGroup;

  constructor(private apiEstado: JuegoService, private data: DatosRetoService) {
    this.formJugador = new FormGroup({
      idJugador: new FormControl(['']),
      nombre: new FormControl(['']),
    });
  }

  ngOnInit(): void {}

  registrar() {
    this.apiEstado.guardarJugador({
      idJugador: this.formJugador.value.idJugador,
      nombre: this.formJugador.value.nombre,
    });

    this.data
      .registrarJugador({
        idJugador: this.formJugador.value.idJugador,
        nombre: this.formJugador.value.nombre,
      })
      .subscribe((val) => {
        this.data
          .registrarJuego({
            jugador: {
              idJugador: val.idJugador,
            },
          })
          .subscribe((value) => {
            this.apiEstado.idJuego = value.idJuego;
            this.apiEstado.guardarRegistra({idJuego:value.idJuego});
          });
      });
  }
}
