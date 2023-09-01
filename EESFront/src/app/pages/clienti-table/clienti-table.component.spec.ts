import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientiTableComponent } from './clienti-table.component';

describe('ClientiTableComponent', () => {
  let component: ClientiTableComponent;
  let fixture: ComponentFixture<ClientiTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClientiTableComponent]
    });
    fixture = TestBed.createComponent(ClientiTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
