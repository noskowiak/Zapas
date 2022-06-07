import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockbasementformComponent } from './stockbasementform.component';

describe('StockbasementformComponent', () => {
  let component: StockbasementformComponent;
  let fixture: ComponentFixture<StockbasementformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockbasementformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockbasementformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
