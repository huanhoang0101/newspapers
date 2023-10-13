import { TestBed } from '@angular/core/testing';

import { DetaiNewspaperService } from './detail-newspaper.service';

describe('DetaiNewspaperService', () => {
  let service: DetaiNewspaperService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetaiNewspaperService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
