import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockgarageformComponent } from './stockgarageform.component';

describe('StockgarageformComponent', () => {
  let component: StockgarageformComponent;
  let fixture: ComponentFixture<StockgarageformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockgarageformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockgarageformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
