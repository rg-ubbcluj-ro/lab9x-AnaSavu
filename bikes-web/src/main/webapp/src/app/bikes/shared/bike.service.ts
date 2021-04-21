import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Bike} from "./bike.model";

import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class BikeService {
  private bikesUrl = 'http://localhost:8080/api/bikes';

  constructor(private httpClient: HttpClient) {
  }

  getBikes(): Observable<Bike[]> {
    return this.httpClient
      .get<Array<Bike>>(this.bikesUrl);
  }

  // getBike(id: number): Observable<Bike> {
  //   return this.getBikes()
  //     .pipe(
  //       map(bikes => bikes.find(bike => bike.id === id))
  //     );
  // }
  //
  // update(bike): Observable<Bike> {
  //   const url = `${this.studentsUrl}/${bike.id}`;
  //   return this.httpClient
  //     .put<Bike>(url, bike);
  // }

}