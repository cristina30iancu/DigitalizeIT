import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItSupportNjComponent } from './it-support-nj.component';

describe('ItSupportNjComponent', () => {
  let component: ItSupportNjComponent;
  let fixture: ComponentFixture<ItSupportNjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItSupportNjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItSupportNjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
