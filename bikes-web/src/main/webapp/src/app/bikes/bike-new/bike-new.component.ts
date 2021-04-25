import { Component, OnInit } from '@angular/core';
import {BikeService} from "../shared/bike.service";
import {Bike} from "../shared/bike.model";
import {Location} from "@angular/common";

@Component({
  selector: 'app-bike-new',
  templateUrl: './bike-new.component.html',
  styleUrls: ['./bike-new.component.css']
})
export class BikeNewComponent implements OnInit {

  constructor(private bikeService: BikeService, private location: Location) { }

  ngOnInit(): void {
  }

  saveBike(serialNumber: string, manufacturer: string, color: string, price: string) {
    const bike: Bike = <Bike>{
      serialNumber,
      manufacturer,
      color,
      price: +price
    };
    this.bikeService.saveBike(bike).subscribe(b1 => console.log('saved bike: ', b1));
  }

  goBack() {
    this.location.back();
  }
}
