import {Component, OnInit} from '@angular/core';
import {QuoteService} from "../entities/quote.service";

@Component({
  selector: 'app-tab1',
  templateUrl: 'quote.page.html',
  styleUrls: ['quote.page.scss']
})
export class QuotePage implements OnInit{

  quotes = [];

  constructor(private quoteService: QuoteService) {

  }

  loadQuotes() {
    this.quoteService.getQuotes(3).subscribe(q => {
      this.quotes = q;
    })
  }

  ngOnInit() {
    this.loadQuotes();
  }

}
