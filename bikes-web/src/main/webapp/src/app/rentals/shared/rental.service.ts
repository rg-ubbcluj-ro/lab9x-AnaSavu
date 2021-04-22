import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Rental} from "./rental.module";

@Injectable()
export class RentalService{
  private rentalsUrl = 'http://localhost:8080/api/rentals';

  constructor(private httpClient: HttpClient) {
  }

  getRentals(): Observable<Rental[]> {
    return this.httpClient.get<Array<Rental>>(this.rentalsUrl);
  }
}
