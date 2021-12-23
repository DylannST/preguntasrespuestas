import { ConfigurarJuegoComponent } from './configurar-juego/configurar-juego.component';
import { InicioComponent } from './inicio/inicio.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'configuracionForm', component: ConfigurarJuegoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
