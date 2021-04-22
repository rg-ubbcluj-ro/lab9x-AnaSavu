import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Client} from "./client.model";

@Injectable()
export class ClientService {
  private clientsUrl = 'http://localhost:8080/api/clients';

  constructor(private httpClient: HttpClient) {
  }

  getClients(): Observable<Client[]> {
    return this.httpClient
      .get<Array<Client>>(this.clientsUrl);
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

