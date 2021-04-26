import { Component, OnInit } from '@angular/core';
import {Shop} from "../shared/shop.model";
import {ShopService} from "../shared/shop.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.css']
})
export class ShopListComponent implements OnInit {
  errorMessage = "";
  shops: Array<Shop> = [];
  selectedShop: Shop = {
    id: 0,
    name: "",
    city: ""
  };

  constructor(private shopService: ShopService, private router: Router) { }

  ngOnInit(): void {
    this.shopService.getShops().subscribe(shops => this.shops = shops);
  }

  getShops() {
    this.shopService.getShops().subscribe(shops => this.shops = shops,
      error => this.errorMessage = <any>error)
  }

  onSelect(shop: Shop): void {
    this.selectedShop = shop;
  }

  onDoubleSelect(shop: Shop): void {
    this.selectedShop = shop;
    this.router.navigate(['shop/detail', this.selectedShop.id]);
  }

  gotoDetail() {
    this.router.navigate(['shop/detail', this.selectedShop.id]);
  }

  deleteShop(id: number) {
    this.shopService.deleteShop(id).subscribe(() => console.log('deleted shop'));
  }

  updateShop() {
    this.router.navigate(['shop/update', this.selectedShop.id]);
  }
}
