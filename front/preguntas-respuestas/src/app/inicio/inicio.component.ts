import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css'],
})
export class InicioComponent implements OnInit {
  estado: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  cambio() {
    this.estado = true;
  }

  cerrar(event: any) {
    this.estado = event;
  }
}
