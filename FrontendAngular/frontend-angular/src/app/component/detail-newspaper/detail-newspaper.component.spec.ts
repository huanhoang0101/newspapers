import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailNewspaperComponent } from './detail-newspaper.component';

describe('DetailNewspaperComponent', () => {
  let component: DetailNewspaperComponent;
  let fixture: ComponentFixture<DetailNewspaperComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailNewspaperComponent]
    });
    fixture = TestBed.createComponent(DetailNewspaperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
