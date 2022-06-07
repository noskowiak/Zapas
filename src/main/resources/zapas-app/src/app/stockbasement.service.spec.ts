import { TestBed } from '@angular/core/testing';

import { StockbasementService } from './stockbasement.service';

describe('StockbasementService', () => {
  let service: StockbasementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockbasementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
