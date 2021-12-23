import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-configurar-juego',
  templateUrl: './configurar-juego.component.html',
  styleUrls: ['./configurar-juego.component.css'],
})
export class ConfigurarJuegoComponent implements OnInit {
  @Output() estado = new EventEmitter<boolean>();
  constructor() {}

  ngOnInit(): void {}

    cambio() {
    this.estado.emit(false);
  }
  
}
