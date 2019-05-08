import { TestBed } from '@angular/core/testing';

import { ProductownerdetailsService } from './productownerdetails.service';

describe('ProductownerdetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductownerdetailsService = TestBed.get(ProductownerdetailsService);
    expect(service).toBeTruthy();
  });
});
