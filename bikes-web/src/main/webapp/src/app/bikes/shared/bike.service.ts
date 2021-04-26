import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Bike} from "./bike.model";

import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class BikeService {
  private bikesUrl = 'http://localhost:8080/api/bikes';

  constructor(private httpClient: HttpClient) {
    const headers = { 'Authorization': 'Bearer my-token', 'My-Custom-Header': 'foobar' };
  }

  getBikes(): Observable<Bike[]> {
    return this.httpClient
      .get<Array<Bike>>(this.bikesUrl);
  }

  getBike(id: number): Observable<Bike> {
    // @ts-ignore
    return this.getBikes().pipe(
      map(bikes => bikes.find(bike => bike.id === id)));
  }

  saveBike(bike: Bike): Observable<Bike> {
    return this.httpClient.post<Bike>(this.bikesUrl, bike);
  }

  deleteBike(id: number): Observable<Bike> {
    const endPoints = '/' + id;
    return this.httpClient.delete<Bike>(this.bikesUrl + endPoints);
  }

  updateBike(bike: Bike) {
    const endPoints = '/' + bike.id;
    return this.httpClient.put<Bike>(this.bikesUrl + endPoints, bike);
  }
}
