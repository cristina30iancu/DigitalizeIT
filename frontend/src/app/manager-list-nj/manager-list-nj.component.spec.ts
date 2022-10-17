import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerListNjComponent } from './manager-list-nj.component';

describe('ManagerListNjComponent', () => {
  let component: ManagerListNjComponent;
  let fixture: ComponentFixture<ManagerListNjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerListNjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerListNjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
