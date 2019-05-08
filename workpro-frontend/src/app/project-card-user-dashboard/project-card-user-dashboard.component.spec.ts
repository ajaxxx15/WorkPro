import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCardUserDashboardComponent } from './project-card-user-dashboard.component';

describe('ProjectCardUserDashboardComponent', () => {
  let component: ProjectCardUserDashboardComponent;
  let fixture: ComponentFixture<ProjectCardUserDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectCardUserDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCardUserDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
