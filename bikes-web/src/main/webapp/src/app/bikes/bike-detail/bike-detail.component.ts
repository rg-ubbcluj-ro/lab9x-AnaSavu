import {Component, Input, OnInit} from '@angular/core';
import {Bike} from "../shared/bike.model";
import {BikeService} from "../shared/bike.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-bike-detail',
  templateUrl: './bike-detail.component.html',
  styleUrls: ['./bike-detail.component.css']
})
export class BikeDetailComponent implements OnInit {

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

  goBack() {
    this.location.back();
  }
}
