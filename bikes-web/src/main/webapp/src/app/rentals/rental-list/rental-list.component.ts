import { Component, OnInit } from '@angular/core';
import {Rental} from "../shared/rental.module";
import {RentalService} from "../shared/rental.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-rental-list',
  templateUrl: './rental-list.component.html',
  styleUrls: ['./rental-list.component.css']
})
export class RentalListComponent implements OnInit {
  errorMessage = "";
  rentals : Array<Rental> = [];
  selectedRental : Rental = {
    id: 0,
    daysRented: 0,
    bikeID: 0,
    clientID: 0,
    employeeID: 0,
    shopID: 0
  };

  constructor(private rentalService: RentalService, private router: Router) { }

  ngOnInit(): void {
    this.rentalService.getRentals().subscribe(rentals => this.rentals = rentals);
  }

  getRentals() {
    this.rentalService.getRentals().subscribe(
      rentals => this.rentals = rentals,
      error => this.errorMessage = <any>error
    );
  }

  onSelect(rental: Rental) {
    this.selectedRental = rental;
  }

  gotoDetail() {
    this.router.navigate(['rental/detail', this.selectedRental.id]);
  }

  onDoubleSelect(rental: Rental) {
    this.selectedRental = rental;
    this.router.navigate(['rental/detail', this.selectedRental.id]);
  }
}
