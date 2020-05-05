import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './component/admin/admin.component';
import {QuoteService} from "./entities/quote.service";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './component/home/home.component';
import {ReactiveFormsModule} from "@angular/forms";
import {SubscriptionService} from "./entities/subscription.service";

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [QuoteService, SubscriptionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
