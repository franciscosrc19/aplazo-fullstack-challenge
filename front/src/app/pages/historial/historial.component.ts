import { Component, OnInit } from '@angular/core';
import { LoanService } from '../../services/loan.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  standalone: true,
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  loans: any[] = [];

  constructor(private loanService: LoanService) {}

  ngOnInit() {
    this.loanService.loans$.subscribe(loans => {
      this.loans = loans;
    });
  }
}
