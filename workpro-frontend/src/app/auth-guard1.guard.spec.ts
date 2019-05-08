import { TestBed, async, inject } from '@angular/core/testing';

import { AuthGuard1Guard } from './auth-guard1.guard';

describe('AuthGuard1Guard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthGuard1Guard]
    });
  });

  it('should ...', inject([AuthGuard1Guard], (guard: AuthGuard1Guard) => {
    expect(guard).toBeTruthy();
  }));
});
