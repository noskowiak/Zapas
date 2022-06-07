import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockgarageComponent } from './stockgarage.component';

describe('StockgarageComponent', () => {
  let component: StockgarageComponent;
  let fixture: ComponentFixture<StockgarageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockgarageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockgarageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
