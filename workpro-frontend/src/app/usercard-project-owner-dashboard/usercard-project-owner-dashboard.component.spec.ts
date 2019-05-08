import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsercardProjectOwnerDashboardComponent } from './usercard-project-owner-dashboard.component';

describe('UsercardProjectOwnerDashboardComponent', () => {
  let component: UsercardProjectOwnerDashboardComponent;
  let fixture: ComponentFixture<UsercardProjectOwnerDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsercardProjectOwnerDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsercardProjectOwnerDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
