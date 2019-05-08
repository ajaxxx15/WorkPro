import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCardProductOwnerMyprojectComponent } from './project-card-product-owner-myproject.component';

describe('ProjectCardProductOwnerMyprojectComponent', () => {
  let component: ProjectCardProductOwnerMyprojectComponent;
  let fixture: ComponentFixture<ProjectCardProductOwnerMyprojectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectCardProductOwnerMyprojectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCardProductOwnerMyprojectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
