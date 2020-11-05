import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListWishlistComponent } from './list-wishlist.component';

describe('ListWishlistComponent', () => {
  let component: ListWishlistComponent;
  let fixture: ComponentFixture<ListWishlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListWishlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListWishlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
