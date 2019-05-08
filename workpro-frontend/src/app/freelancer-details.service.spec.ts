import { TestBed } from '@angular/core/testing';

import { FreelancerDetailsService } from './freelancer-details.service';

describe('FreelancerDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FreelancerDetailsService = TestBed.get(FreelancerDetailsService);
    expect(service).toBeTruthy();
  });
});
