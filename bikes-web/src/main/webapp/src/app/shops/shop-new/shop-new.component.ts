import { Component, OnInit } from '@angular/core';
import {Shop} from "../shared/shop.model";
import {ShopService} from "../shared/shop.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-shop-new',
  templateUrl: './shop-new.component.html',
  styleUrls: ['./shop-new.component.css']
})
export class ShopNewComponent implements OnInit {

  constructor(private shopService: ShopService, private location: Location) { }

  ngOnInit(): void {
  }

  saveShop(name: string, city: string) {
    const shop: Shop = <Shop>{
      name,
      city
    };
    this.shopService.saveShop(shop).subscribe(s1 => console.log('saved shop: ', s1));
  }

  goBack() {
    this.location.back();
  }
}
