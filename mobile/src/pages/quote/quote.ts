import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';
import {QuoteService} from "../../entities/quote.service";

@Component({
  selector: 'page-quote',
  templateUrl: 'quote.html'
})
export class QuotePage {
  // quotes = [
  //   new Quote(1, "dsf", "dssssssssf", 1, 2, 3),
  //   new Quote(1, "dsdsfdsff", "dsf", 1, 2, 3),
  //   new Quote(1, "dsf", "dsf", 1, 2, 3),
  // ];

  quotes = [];

  constructor(public navCtrl: NavController, private quoteService: QuoteService) {

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
