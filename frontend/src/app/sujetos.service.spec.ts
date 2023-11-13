import { TestBed } from '@angular/core/testing';

import { SujetosService } from './sujetos.service';

describe('SujetosService', () => {
  let service: SujetosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SujetosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
