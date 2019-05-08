import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerdetailsComponent } from './freelancerdetails.component';

describe('FreelancerdetailsComponent', () => {
  let component: FreelancerdetailsComponent;
  let fixture: ComponentFixture<FreelancerdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreelancerdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
