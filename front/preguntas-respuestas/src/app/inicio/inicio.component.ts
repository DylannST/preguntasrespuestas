import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css'],
})
export class InicioComponent implements OnInit {
  estado: boolean = false;
  estadoJuego: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  cambio() {
    this.estadoJuego = false;
    this.estado = true;
  }

  cambioJuego() {
    this.estado = false;
    this.estadoJuego = true;
  }

  cerrar(event: any) {
    this.estado = event;
  }

  cerrarJuego(event: any) {
    this.estadoJuego = event;
  }
}
