import {Component, OnInit} from '@angular/core';
import {QuoteService} from "../../entities/quote.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-quote-view',
  templateUrl: './quote-view.component.html',
  styleUrls: ['./quote-view.component.css']
})
export class QuoteViewComponent implements OnInit {

  public quote;

  constructor(private quoteService: QuoteService, private route: ActivatedRoute) {
    this.getQuote(this.route.snapshot.params.id);
  }

  ngOnInit(): void {
  }

  getQuote(id: number) {
    this.quoteService.getQuoteById(id).subscribe(
      d => {
        this.quote = d;
      },
      error => console.error(error),
      () => console.log("Quote Loaded")
    )
  }
}
