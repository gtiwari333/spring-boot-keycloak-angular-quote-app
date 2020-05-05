import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { QuotePage } from './quote.page';

import { QuoteRoutingModule } from './quote-routing.module';
import {QuoteItem} from "../quote-item/quote-item";

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    QuoteRoutingModule
  ],
  exports: [QuoteItem],
  declarations: [QuotePage, QuoteItem]
})
export class QuoteModule {}
