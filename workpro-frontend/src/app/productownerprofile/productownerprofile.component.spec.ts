import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductownerprofileComponent } from './productownerprofile.component';

describe('ProductownerprofileComponent', () => {
  let component: ProductownerprofileComponent;
  let fixture: ComponentFixture<ProductownerprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductownerprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductownerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
