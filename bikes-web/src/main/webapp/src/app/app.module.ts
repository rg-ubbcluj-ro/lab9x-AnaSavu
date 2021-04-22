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
    RentalListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [BikeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
