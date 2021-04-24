import {Component, Input, OnInit} from '@angular/core';
import {ShopService} from "../shared/shop.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {Shop} from "../shared/shop.model";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-shop-detail',
  templateUrl: './shop-detail.component.html',
  styleUrls: ['./shop-detail.component.css']
})
export class ShopDetailComponent implements OnInit {
  @Input() shop: Shop = {
    id: 0,
    name: "",
    city: ""
  };

  constructor(private shopService: ShopService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.shopService.getShop(+params['id'])))
      .subscribe(shop => this.shop = shop);
  }

  goBack() {
    this.location.back();
  }

}
