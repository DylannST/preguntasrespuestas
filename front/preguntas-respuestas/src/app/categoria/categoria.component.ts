import { TestSofkaService } from './../servicio/test-sofka.service';
import { DatosRetoService } from '../servicio/datos-reto.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css'],
})
export class CategoriaComponent implements OnInit {
  niveles: string[] = [];
  categoria: any[] = [];
  formCategoria: FormGroup;
  constructor(
    private data: DatosRetoService,
    private apiEstado: TestSofkaService
  ) {
    this.formCategoria = new FormGroup({
      descrip: new FormControl(['']),
      dificultad: new FormControl(['']),
    });
  }

  ngOnInit(): void {
    this.obtenerDificultad();
  }

  eliminarItem(item: any) {
    let op = confirm('¿Esta seguro de eliminarlo?');

    if (op) {
      this.categoria = this.categoria.filter(
        (obj) => obj.descrip !== item.descrip
      );
      this.apiEstado.guardarCategoria(this.categoria);
    }
  }

  obtenerDificultad() {
    this.data.getDificultad().subscribe((dificultad) => {
      this.niveles = dificultad;
    });
  }
  agregar() {
    this.categoria = [...this.categoria, this.formCategoria.value];
    this.formCategoria.reset();
  }
  guardar() {
    this.apiEstado.guardarCategoria(this.categoria);
  }
}
