import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AdminComponent} from "./component/admin/admin.component";
import {HomeComponent} from "./component/home/home.component";


const routes: Routes = [
  {
    path: 'admin', component: AdminComponent
  },
  {
    path: '', component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
