import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikesListComponent } from './bikes/bike-list/bikes-list.component';
import {BikeService} from "./bikes/shared/bike.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ClientsComponent } from './clients/clients.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeListComponent } from './employees/employee-list/employee-list.component';
import { RentalsComponent } from './rentals/rentals.component';
import { RentalListComponent } from './rentals/rental-list/rental-list.component';
import {ClientService} from "./clients/shared/client.service";
import {EmployeeService} from "./employees/shared/employee.service";
import {RentalService} from "./rentals/shared/rental.service";
import { BikeDetailComponent } from './bikes/bike-detail/bike-detail.component';
import { ClientDetailComponent } from './clients/client-detail/client-detail.component';
import { RentalDetailComponent } from './rentals/rental-detail/rental-detail.component';
import { EmployeeDetailComponent } from './employees/employee-detail/employee-detail.component';
import { ShopsComponent } from './shops/shops.component';
import {ShopService} from "./shops/shared/shop.service";
import { ShopListComponent } from './shops/shop-list/shop-list.component';
import { ShopDetailComponent } from './shops/shop-detail/shop-detail.component';
import { BikeNewComponent } from './bikes/bike-new/bike-new.component';
import { BikeUpdateComponent } from './bikes/bike-update/bike-update.component';
import { ClientNewComponent } from './clients/client-new/client-new.component';
import { ClientUpdateComponent } from './clients/client-update/client-update.component';
import { ShopNewComponent } from './shops/shop-new/shop-new.component';
import { ShopUpdateComponent } from './shops/shop-update/shop-update.component';
import { EmployeeNewComponent } from './employees/employee-new/employee-new.component';
import { EmployeeUpdateComponent } from './employees/employee-update/employee-update.component';

@NgModule({
  declarations: [
    AppComponent,
    BikesComponent,
    BikesListComponent,
    ClientsComponent,
    ClientListComponent,
    EmployeesComponent,
    EmployeeListComponent,
    RentalsComponent,
    RentalListComponent,
    BikeDetailComponent,
    ClientDetailComponent,
    RentalDetailComponent,
    EmployeeDetailComponent,
    ShopsComponent,
    ShopListComponent,
    ShopDetailComponent,
    BikeNewComponent,
    BikeUpdateComponent,
    ClientNewComponent,
    ClientUpdateComponent,
    ShopNewComponent,
    ShopUpdateComponent,
    EmployeeNewComponent,
    EmployeeUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [BikeService, ClientService, EmployeeService, RentalService, ShopService],
  bootstrap: [AppComponent]
})
export class AppModule { }
