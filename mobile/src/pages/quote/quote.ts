import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';

@Component({
  selector: 'page-quote',
  templateUrl: 'quote.html'
})
export class QuotePage {
  quotes = [
    {author: "Author 1", content: "A quote....", viewCount: "1"},
    {author: "Author A", content: "AA quote....", viewCount: "10"},
    {author: "Author 2", content: "A quote 2....", viewCount: "2"}];

  constructor(public navCtrl: NavController) {

  }

}
