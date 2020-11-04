import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRetailersComponent } from './list-retailers.component';

describe('ListRetailersComponent', () => {
  let component: ListRetailersComponent;
  let fixture: ComponentFixture<ListRetailersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListRetailersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListRetailersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
