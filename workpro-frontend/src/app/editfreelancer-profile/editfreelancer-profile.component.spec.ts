import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditfreelancerProfileComponent } from './editfreelancer-profile.component';

describe('EditfreelancerProfileComponent', () => {
  let component: EditfreelancerProfileComponent;
  let fixture: ComponentFixture<EditfreelancerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditfreelancerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditfreelancerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
