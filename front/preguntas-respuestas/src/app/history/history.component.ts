import { JuegoService } from './../servicio/juego.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  carga:any
  constructor(private apiEstado:JuegoService) { }

  ngOnInit(): void {
    this.carga=this.apiEstado.historial;
  }

}
