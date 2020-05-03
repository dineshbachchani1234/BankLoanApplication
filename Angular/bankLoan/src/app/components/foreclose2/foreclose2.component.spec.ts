import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Foreclose2Component } from './foreclose2.component';

describe('Foreclose2Component', () => {
  let component: Foreclose2Component;
  let fixture: ComponentFixture<Foreclose2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Foreclose2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Foreclose2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
