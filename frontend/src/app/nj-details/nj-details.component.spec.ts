import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NjDetailsComponent } from './nj-details.component';

describe('NjDetailsComponent', () => {
  let component: NjDetailsComponent;
  let fixture: ComponentFixture<NjDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NjDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NjDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
