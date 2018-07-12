import {Component} from '@angular/core';

import {AboutPage} from '../about/about';
import {QuotePage} from '../quote/quote';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = QuotePage;
  tab2Root = AboutPage;

  constructor() {

  }
}
