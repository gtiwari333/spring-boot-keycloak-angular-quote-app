import {ErrorHandler, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {IonicApp, IonicErrorHandler, IonicModule} from 'ionic-angular';
import { HttpClientModule } from '@angular/common/http';
import {MyApp} from './app.component';

import {AboutPage} from '../pages/about/about';
import {QuotePage} from '../pages/quote/quote';
import {TabsPage} from '../pages/tabs/tabs';
import {QuoteService} from "../entities/quote.service";

import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import {QuoteItem} from "../pages/quote-item/quote-item";

@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    QuotePage,
    QuoteItem,
    TabsPage
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    QuotePage,
    QuoteItem,
    TabsPage
  ],
  providers: [
    QuoteService,
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {
}
