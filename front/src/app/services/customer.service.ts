import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = '/v1/customers';
  private customersSubject = new BehaviorSubject<any[]>([]);
  customers$ = this.customersSubject.asObservable();

  constructor(private http: HttpClient) {}

  createCustomer(customer: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, customer).pipe(
      map(response => {
        this.customersSubject.next([...this.customersSubject.value, response]);
        return response;
      })
    );
  }

  getCustomerById(customerId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${customerId}`);
  }
}