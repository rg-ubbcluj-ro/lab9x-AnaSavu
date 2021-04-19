import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BikesComponent} from "./bikes/bikes.component";

const routes: Routes = [
  {path: 'bikes', component: BikesComponent},
  // {path 'bike/detail/:id', component: BikeDe}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
