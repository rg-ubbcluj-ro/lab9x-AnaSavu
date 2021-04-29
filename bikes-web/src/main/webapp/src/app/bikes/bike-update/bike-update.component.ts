import {Component, Input, OnInit} from '@angular/core';
import {Bike} from "../shared/bike.model";
import {BikeService} from "../shared/bike.service";
import {Location} from "@angular/common";
import {ActivatedRoute, Params} from "@angular/router";
import {switchMap} from "rxjs/operators";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-bike-update',
  templateUrl: './bike-update.component.html',
  styleUrls: ['./bike-update.component.css']
})
export class BikeUpdateComponent implements OnInit {
  @Input() bike: Bike = {
    id: 0,
    serialNumber: "",
    manufacturer: "",
    color: "",
    price: 0
  };

  constructor(private bikeService: BikeService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.bikeService.getBike(+params['id'])))
      .subscribe(bike => this.bike = bike);
  }

  updateBike(serialNumber: string, manufacturer: string, color: string, price: string, id: number) {
    const bike: Bike = <Bike>{
      id,
      serialNumber,
      manufacturer,
      color,
      price: +price
    };
    this.bikeService.updateBike(bike).subscribe(b1 => console.log('updated bike: ', b1));
  }
  goBack() {
    this.location.back();
  }

  onSubmit() {

  }
}
