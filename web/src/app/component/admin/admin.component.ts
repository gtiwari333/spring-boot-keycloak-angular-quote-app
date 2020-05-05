import { Component, OnInit } from '@angular/core';
import {IQuote} from "../../entities/quote.model";
import {QuoteService} from "../../entities/quote.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public quotes: IQuote[];


  constructor(private quoteService: QuoteService) {
  }

  ngOnInit(): void {
    this.getQuotes();
  }


  getQuotes() {
    this.quoteService.getQuotes(20).subscribe(
      d => {
        this.quotes = d
      },
      err => console.error(err),
      () => console.log("Quotes loaded")
    )
  }

}
