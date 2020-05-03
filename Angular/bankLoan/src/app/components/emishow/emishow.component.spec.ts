import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmishowComponent } from './emishow.component';

describe('EmishowComponent', () => {
  let component: EmishowComponent;
  let fixture: ComponentFixture<EmishowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmishowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmishowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
