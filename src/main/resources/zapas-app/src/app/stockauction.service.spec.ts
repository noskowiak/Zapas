import { TestBed } from '@angular/core/testing';

import { StockauctionService } from './stockauction.service';

describe('StockauctionService', () => {
  let service: StockauctionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockauctionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
