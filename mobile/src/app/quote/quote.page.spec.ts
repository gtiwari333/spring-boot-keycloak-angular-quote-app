import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { QuotePage } from './quote.page';

describe('Tab1Page', () => {
  let component: QuotePage;
  let fixture: ComponentFixture<QuotePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [QuotePage],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(QuotePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
