import {BrowserModule} from '@angular/platform-browser';
import {NgModule, APP_INITIALIZER} from '@angular/core';

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

import {KeycloakService, KeycloakAngularModule} from "keycloak-angular";
import {environment} from "../environments/environment";

export function kcInitializer(keycloak: KeycloakService): () => Promise<any> {
  return (): Promise<any> => {
    return new Promise(async (resolve, reject) => {
      try {
        await keycloak.init(environment.keycloakOptions);
        console.log('Keycloak is initialized');
        resolve();
      } catch (error) {
        console.log('Error thrown in init ' + error);
        reject(error);
      }
    });
  };
}

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
    KeycloakAngularModule,
    CollapseModule
  ],
  providers: [QuoteService, SubscriptionService,
    { provide: APP_INITIALIZER, useFactory: kcInitializer, multi: true, deps: [KeycloakService] },],
  bootstrap: [AppComponent]
})
export class AppModule {
}
