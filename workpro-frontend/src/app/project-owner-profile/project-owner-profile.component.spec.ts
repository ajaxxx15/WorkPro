import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectOwnerProfileComponent } from './project-owner-profile.component';

describe('ProjectOwnerProfileComponent', () => {
  let component: ProjectOwnerProfileComponent;
  let fixture: ComponentFixture<ProjectOwnerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectOwnerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectOwnerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
