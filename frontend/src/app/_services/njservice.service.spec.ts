import { TestBed } from '@angular/core/testing';

import { NjserviceService } from './njservice.service';

describe('NjserviceService', () => {
  let service: NjserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NjserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
