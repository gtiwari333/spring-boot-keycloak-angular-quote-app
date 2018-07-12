import {Component, Input} from '@angular/core';
import {Quote} from "../../entities/quote.model";

@Component({
  selector: 'quote-item',
  templateUrl: 'quote-item.html'
})
export class QuoteItem {
  @Input() quote:  Array<Quote>;

  constructor( ) {

  }

}
