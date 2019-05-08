import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ViewProfileDailogComponent } from './view-profile-dailog.component';

describe('ViewProfileDailogComponent', () => {
  let component: ViewProfileDailogComponent;
  let fixture: ComponentFixture<ViewProfileDailogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewProfileDailogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProfileDailogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
