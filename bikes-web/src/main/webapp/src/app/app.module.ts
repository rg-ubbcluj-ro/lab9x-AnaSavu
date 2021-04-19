import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikesListComponent } from './bikes/bikes-list/bikes-list.component';

@NgModule({
  declarations: [
    AppComponent,
    BikesComponent,
    BikesListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
