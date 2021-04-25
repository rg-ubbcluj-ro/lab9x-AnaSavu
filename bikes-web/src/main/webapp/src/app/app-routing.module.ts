import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BikesComponent} from "./bikes/bikes.component";
import {EmployeesComponent} from "./employees/employees.component";
import {ClientsComponent} from "./clients/clients.component";
import {RentalsComponent} from "./rentals/rentals.component";
import {BikeDetailComponent} from "./bikes/bike-detail/bike-detail.component";
import {ClientDetailComponent} from "./clients/client-detail/client-detail.component";
import {RentalDetailComponent} from "./rentals/rental-detail/rental-detail.component";
import {EmployeeDetailComponent} from "./employees/employee-detail/employee-detail.component";
import {ShopsComponent} from "./shops/shops.component";
import {ShopDetailComponent} from "./shops/shop-detail/shop-detail.component";
import {BikeNewComponent} from "./bikes/bike-new/bike-new.component";

const routes: Routes = [
  {path: 'bikes', component: BikesComponent},
  {path: 'clients', component: ClientsComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'rentals', component: RentalsComponent},
  {path: 'shops', component: ShopsComponent},
  {path: 'bike/detail/:id', component: BikeDetailComponent},
  {path: 'client/detail/:id', component: ClientDetailComponent},
  {path: 'employee/detail/:id', component: EmployeeDetailComponent},
  {path: 'rental/detail/:id', component: RentalDetailComponent},
  {path: 'shop/detail/:id', component: ShopDetailComponent},
  {path: 'bike-new', component: BikeNewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
