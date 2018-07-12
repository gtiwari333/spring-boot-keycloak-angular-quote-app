import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';
import {Quote} from "../../entities/quote.model";

@Component({
  selector: 'page-quote',
  templateUrl: 'quote.html'
})
export class QuotePage {
  quotes = [
    new Quote(1, "dsf", "dssssssssf", 1, 2, 3),
    new Quote(1, "dsdsfdsff", "dsf", 1, 2, 3),
    new Quote(1, "dsf", "dsf", 1, 2, 3),
  ];

  constructor(public navCtrl: NavController) {

  }

}
