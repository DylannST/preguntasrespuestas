import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {
  @Output() estado = new EventEmitter<boolean>();
  constructor() { }

  ngOnInit(): void {
  }
  cambio() {
    this.estado.emit(false);
  }

}
