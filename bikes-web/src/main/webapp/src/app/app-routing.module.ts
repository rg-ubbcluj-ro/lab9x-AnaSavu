import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BikesComponent} from "./bikes/bikes.component";
import {EmployeesComponent} from "./employees/employees.component";
import {ClientsComponent} from "./clients/clients.component";
import {RentalsComponent} from "./rentals/rentals.component";
import {BikeDetailComponent} from "./bikes/bike-detail/bike-detail.component";

const routes: Routes = [
  {path: 'bikes', component: BikesComponent},
  {path: 'clients', component: ClientsComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'rentals', component: RentalsComponent},
  {path: 'bike/detail/:id', component: BikeDetailComponent}
  // {path 'bike/detail/:id', component: BikeDe}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
