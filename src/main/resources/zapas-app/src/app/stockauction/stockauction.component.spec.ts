import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StockauctionComponent } from './stockauction.component';

describe('StockauctionComponent', () => {
  let component: StockauctionComponent;
  let fixture: ComponentFixture<StockauctionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StockauctionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StockauctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
