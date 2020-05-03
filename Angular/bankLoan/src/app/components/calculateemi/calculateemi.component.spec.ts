import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculateemiComponent } from './calculateemi.component';

describe('CalculateemiComponent', () => {
  let component: CalculateemiComponent;
  let fixture: ComponentFixture<CalculateemiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalculateemiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculateemiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
