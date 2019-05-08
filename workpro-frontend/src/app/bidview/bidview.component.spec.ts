import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BidviewComponent } from './bidview.component';

describe('BidviewComponent', () => {
  let component: BidviewComponent;
  let fixture: ComponentFixture<BidviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BidviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BidviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
