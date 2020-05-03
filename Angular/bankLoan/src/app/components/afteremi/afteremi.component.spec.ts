import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfteremiComponent } from './afteremi.component';

describe('AfteremiComponent', () => {
  let component: AfteremiComponent;
  let fixture: ComponentFixture<AfteremiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfteremiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfteremiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
