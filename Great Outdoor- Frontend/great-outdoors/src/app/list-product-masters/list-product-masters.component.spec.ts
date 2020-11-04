import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProductMastersComponent } from './list-product-masters.component';

describe('ListProductMastersComponent', () => {
  let component: ListProductMastersComponent;
  let fixture: ComponentFixture<ListProductMastersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListProductMastersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListProductMastersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
