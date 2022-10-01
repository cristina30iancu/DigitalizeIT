import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewjoinerComponent } from './newjoiner.component';

describe('NewjoinerComponent', () => {
  let component: NewjoinerComponent;
  let fixture: ComponentFixture<NewjoinerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewjoinerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewjoinerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
