import { Component, OnInit } from '@angular/core';
import {Bike} from "../shared/bike.model";
import {BikeService} from "../shared/bike.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bikes-list',
  templateUrl: './bikes-list.component.html',
  styleUrls: ['./bikes-list.component.css']
})
export class BikesListComponent implements OnInit {
  errorMessage = "";
  bikes : Array<Bike> = [];
  selectedBike : Bike = {
    id: 0,
    serialNumber: "",
    manufacturer: "",
    color: "",
    price: 0
  };


  constructor(private bikeService: BikeService, private router: Router) { }

  ngOnInit(): void {
    this.bikeService.getBikes().subscribe(bikes => this.bikes=bikes);
  }

  getBikes() {
    this.bikeService.getBikes()
      .subscribe(
        bikes => this.bikes = bikes,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(bike: Bike): void {
    this.selectedBike = bike;
  }

  onDoubleSelect(bike: Bike): void {
    this.selectedBike = bike;
    this.router.navigate(['bike/detail', this.selectedBike.id]);
  }

  gotoDetail() {
    this.router.navigate(['bike/detail', this.selectedBike.id]);
  }

  deleteBike(id: number) {
    this.bikeService.deleteBike(id).subscribe(() => console.log('deleted bike'));
  }

  updateBike() {
    this.router.navigate(['bike/update', this.selectedBike.id]);
  }

}
