import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Shop} from "./shop.model";
import {HttpClient} from "@angular/common/http";
import {Bike} from "../../bikes/shared/bike.model";
import {map} from "rxjs/operators";

@Injectable()
export class ShopService {
  private shopsUrl = 'http://localhost:8080/api/shops';
  constructor(private httpClient: HttpClient) {
  }
  getShops(): Observable<Shop[]> {
    return this.httpClient.get<Array<Shop>>(this.shopsUrl);
  }

  getShop(id: number): Observable<Shop> {
    // @ts-ignore
    return this.getShops().pipe(
      map(shops => shops.find(shop => shop.id === id)));
  }
}
