import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AdminComponent} from "./component/admin/admin.component";
import {HomeComponent} from "./component/home/home.component";
import {QuoteViewComponent} from "./component/quote-view/quote-view.component";
import {AppAuthChecker} from "./app-auth.checker";

const routes: Routes = [
  {
    path: 'admin/quote/:id', component: QuoteViewComponent, canActivate: [AppAuthChecker], data: {roles: ['user']}
  },
  {
    path: 'admin', component: AdminComponent, canActivate: [AppAuthChecker], data: {roles: ['user']}
  },
  {
    path: '', component: HomeComponent
  },
  {
    path: '**', redirectTo: '/'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
