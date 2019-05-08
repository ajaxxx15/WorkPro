import { TestBed, async, inject } from '@angular/core/testing';

import { Authguard3Guard } from './authguard3.guard';

describe('Authguard3Guard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Authguard3Guard]
    });
  });

  it('should ...', inject([Authguard3Guard], (guard: Authguard3Guard) => {
    expect(guard).toBeTruthy();
  }));
});
