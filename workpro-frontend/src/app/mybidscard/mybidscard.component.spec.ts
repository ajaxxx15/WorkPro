import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MybidscardComponent } from './mybidscard.component';

describe('MybidscardComponent', () => {
  let component: MybidscardComponent;
  let fixture: ComponentFixture<MybidscardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MybidscardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MybidscardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
