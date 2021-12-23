import { FormGroup, FormControl } from '@angular/forms';
import { TestSofkaService } from './../servicio/test-sofka.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pregunta',
  templateUrl: './pregunta.component.html',
  styleUrls: ['./pregunta.component.css'],
})
export class PreguntaComponent implements OnInit {
  pregunta: any[] = [];
  categoria: any[] = [];
  formPregunta: FormGroup;

  constructor(private apiEstado: TestSofkaService) {
    this.formPregunta = new FormGroup({
      descrip: new FormControl(['']),
      categori: new FormControl(['']),
    });
  }

  ngOnInit(): void {
    this.apiEstado.obtenerCambioCategoria().subscribe((value) => {
      this.categoria = value;
    });
  }

  agregar() {
    this.pregunta = [...this.pregunta, this.formPregunta.value];
    this.formPregunta.reset();
  }

  eliminar(item: any) {
    let op = confirm('¿Esta seguro de eliminarlo?');
    if (op) {
      this.pregunta = this.pregunta.filter(
        (value) => value.descrip !== item.descrip
      );
    }
  }

  guardar() {
    this.apiEstado.guardarPregunta(this.pregunta);
  }
}
