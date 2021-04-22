import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rental} from "./rental.module";
import {map} from "rxjs/operators";

@Injectable()
export class RentalService{
  private rentalsUrl = 'http://localhost:8080/api/rentals';

  constructor(private httpClient: HttpClient) {
  }

  getRentals(): Observable<Rental[]> {
    return this.httpClient.get<Array<Rental>>(this.rentalsUrl);
  }

  getRental(id: number): Observable<Rental> {
    // @ts-ignore
    return this.getRentals().pipe(
      map(rentals => rentals.find(rental => rental.id === id)));
  }
}
