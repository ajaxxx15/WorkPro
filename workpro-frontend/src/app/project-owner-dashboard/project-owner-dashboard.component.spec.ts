import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectOwnerDashboardComponent } from './project-owner-dashboard.component';

describe('ProjectOwnerDashboardComponent', () => {
  let component: ProjectOwnerDashboardComponent;
  let fixture: ComponentFixture<ProjectOwnerDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectOwnerDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectOwnerDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
