import { TestBed } from '@angular/core/testing';

import { StockgarageService } from './stockgarage.service';

describe('StockgarageService', () => {
  let service: StockgarageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockgarageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
