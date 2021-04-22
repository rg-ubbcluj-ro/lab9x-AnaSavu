import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikesListComponent } from './bikes/bike-list/bikes-list.component';
import {BikeService} from "./bikes/shared/bike.service";
import {FormsModule} from "@angular/forms";
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
    EmployeeDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [BikeService, ClientService, EmployeeService, RentalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
