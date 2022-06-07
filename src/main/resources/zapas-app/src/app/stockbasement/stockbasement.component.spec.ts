import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockbasementComponent } from './stockbasement.component';

describe('StockbasementComponent', () => {
  let component: StockbasementComponent;
  let fixture: ComponentFixture<StockbasementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockbasementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockbasementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
