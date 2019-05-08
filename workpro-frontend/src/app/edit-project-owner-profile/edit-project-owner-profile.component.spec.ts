import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProjectOwnerProfileComponent } from './edit-project-owner-profile.component';

describe('EditProjectOwnerProfileComponent', () => {
  let component: EditProjectOwnerProfileComponent;
  let fixture: ComponentFixture<EditProjectOwnerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditProjectOwnerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProjectOwnerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
