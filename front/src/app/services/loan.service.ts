import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiUrl = '/v1/loans';
  private loansSubject = new BehaviorSubject<any[]>([]);
  loans$ = this.loansSubject.asObservable();

  constructor(private http: HttpClient) {}

  createLoan(loanRequest: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, loanRequest).pipe(
      map(response => {
        this.loansSubject.next([...this.loansSubject.value, response]);
        return response;
      })
    );
  }

  getLoanById(loanId: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${loanId}`);
  }
}