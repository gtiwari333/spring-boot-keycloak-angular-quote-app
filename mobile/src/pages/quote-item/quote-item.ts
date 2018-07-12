import {Component, Input} from '@angular/core';
import {NavController} from 'ionic-angular';

@Component({
  selector: 'quote-item',
  templateUrl: 'quote-item.html'
})
export class QuoteItem {
  @Input() quote: any;

  constructor(public navCtrl: NavController) {

  }

}
