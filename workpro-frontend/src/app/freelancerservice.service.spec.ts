import { TestBed } from '@angular/core/testing';

import { FreelancerserviceService } from './freelancerservice.service';

describe('FreelancerserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FreelancerserviceService = TestBed.get(FreelancerserviceService);
    expect(service).toBeTruthy();
  });
});
