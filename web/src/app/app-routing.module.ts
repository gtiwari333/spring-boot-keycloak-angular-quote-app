import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AdminComponent} from "./component/admin/admin.component";
import {HomeComponent} from "./component/home/home.component";
import {QuoteViewComponent} from "./component/quote-view/quote-view.component";


const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'admin/quote/:id', component: QuoteViewComponent
  },
  {
    path: 'admin', component: AdminComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
