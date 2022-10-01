import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewjoinerListComponent } from './newjoiner-list.component';

describe('NewjoinerListComponent', () => {
  let component: NewjoinerListComponent;
  let fixture: ComponentFixture<NewjoinerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewjoinerListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewjoinerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
