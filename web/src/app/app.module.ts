import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AdminComponent} from './component/admin/admin.component';
import {QuoteService} from "./entities/quote.service";
import {HttpClientModule} from "@angular/common/http";
import {HomeComponent} from './component/home/home.component';
import {ReactiveFormsModule} from "@angular/forms";
import {SubscriptionService} from "./entities/subscription.service";
import {QuoteViewComponent} from './component/quote-view/quote-view.component';
import {CollapseModule} from "ngx-bootstrap/collapse";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    QuoteViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    CollapseModule
  ],
  providers: [QuoteService, SubscriptionService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
