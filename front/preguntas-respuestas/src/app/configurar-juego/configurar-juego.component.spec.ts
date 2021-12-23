import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigurarJuegoComponent } from './configurar-juego.component';

describe('ConfigurarJuegoComponent', () => {
  let component: ConfigurarJuegoComponent;
  let fixture: ComponentFixture<ConfigurarJuegoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfigurarJuegoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigurarJuegoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
