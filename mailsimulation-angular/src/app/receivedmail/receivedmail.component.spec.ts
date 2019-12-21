import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceivedmailComponent } from './receivedmail.component';

describe('ReceivedmailComponent', () => {
  let component: ReceivedmailComponent;
  let fixture: ComponentFixture<ReceivedmailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceivedmailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceivedmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
