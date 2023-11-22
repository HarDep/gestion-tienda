import { TestBed } from '@angular/core/testing';

import { MapperServiceService } from './mapper-service.service';

describe('MapperServiceService', () => {
  let service: MapperServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MapperServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
