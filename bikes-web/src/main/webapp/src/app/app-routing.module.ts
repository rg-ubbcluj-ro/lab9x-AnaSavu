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
import {BikeUpdateComponent} from "./bikes/bike-update/bike-update.component";
import {ClientNewComponent} from "./clients/client-new/client-new.component";
import {ClientUpdateComponent} from "./clients/client-update/client-update.component";
import {ShopNewComponent} from "./shops/shop-new/shop-new.component";
import {ShopUpdateComponent} from "./shops/shop-update/shop-update.component";
import {EmployeeNewComponent} from "./employees/employee-new/employee-new.component";
import {EmployeeUpdateComponent} from "./employees/employee-update/employee-update.component";

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
  {path: 'bike-new', component: BikeNewComponent},
  {path: 'bike/update/:id', component: BikeUpdateComponent},
  {path: 'client-new', component: ClientNewComponent},
  {path: 'client/update/:id', component: ClientUpdateComponent},
  {path: 'shop-new', component: ShopNewComponent},
  {path: 'shop/update/:id', component: ShopUpdateComponent},
  {path: 'employee-new', component: EmployeeNewComponent},
  {path: 'employee/update/:id', component: EmployeeUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
