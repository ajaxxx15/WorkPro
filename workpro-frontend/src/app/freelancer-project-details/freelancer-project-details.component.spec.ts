import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelancerProjectDetailsComponent } from './freelancer-project-details.component';

describe('FreelancerProjectDetailsComponent', () => {
  let component: FreelancerProjectDetailsComponent;
  let fixture: ComponentFixture<FreelancerProjectDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreelancerProjectDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreelancerProjectDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
