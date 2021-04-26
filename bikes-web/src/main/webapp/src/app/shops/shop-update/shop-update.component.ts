import {Component, Input, OnInit} from '@angular/core';
import {switchMap} from "rxjs/operators";
import {ActivatedRoute, Params} from "@angular/router";
import {Shop} from "../shared/shop.model";
import {ShopService} from "../shared/shop.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-shop-update',
  templateUrl: './shop-update.component.html',
  styleUrls: ['./shop-update.component.css']
})
export class ShopUpdateComponent implements OnInit {
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

  updateShop(name: string, city: string, id: number) {
    const shop: Shop = <Shop>{
      id,
      name,
      city
    };
    this.shopService.updateShop(shop).subscribe(s1 => console.log('updated shop: ', s1));
  }

  goBack() {
    this.location.back();
  }
}
