import { TestSofkaService } from './servicio/test-sofka.service';
import { DatosRetoService } from './servicio/datos-reto.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './inicio/inicio.component';
import { ConfigurarJuegoComponent } from './configurar-juego/configurar-juego.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { PreguntaComponent } from './pregunta/pregunta.component';
import { OpcionComponent } from './opcion/opcion.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { JuegoComponent } from './juego/juego.component';
import { RegistroJugadorComponent } from './registro-jugador/registro-jugador.component';
import { PreguntaRespuestaComponent } from './pregunta-respuesta/pregunta-respuesta.component';
import { HistoryComponent } from './history/history.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    ConfigurarJuegoComponent,
    CategoriaComponent,
    PreguntaComponent,
    OpcionComponent,
    JuegoComponent,
    RegistroJugadorComponent,
    PreguntaRespuestaComponent,
    HistoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [DatosRetoService,TestSofkaService],
  bootstrap: [AppComponent],
})
export class AppModule {}
