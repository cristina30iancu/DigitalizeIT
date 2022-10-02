import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListNjComponent } from './list-nj.component';

describe('ListNjComponent', () => {
  let component: ListNjComponent;
  let fixture: ComponentFixture<ListNjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListNjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListNjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
