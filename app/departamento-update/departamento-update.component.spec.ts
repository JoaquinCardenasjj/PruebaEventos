import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepartamentoUpdateComponent } from './departamento-update.component';

describe('DepartamentoUpdateComponent', () => {
  let component: DepartamentoUpdateComponent;
  let fixture: ComponentFixture<DepartamentoUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepartamentoUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepartamentoUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
