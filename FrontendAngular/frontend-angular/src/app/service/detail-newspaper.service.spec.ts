import { TestBed } from '@angular/core/testing';

import { DetailNewspaperService } from './detail-newspaper.service';

describe('DetaiNewspaperService', () => {
  let service: DetailNewspaperService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetailNewspaperService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
