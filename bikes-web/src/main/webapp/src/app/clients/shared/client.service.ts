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

  getClient(id: number): Observable<Client> {
    // @ts-ignore
    return this.getClients().pipe(map(clients => clients.find(client => client.id === id)));
  }

  saveClient(client: Client): Observable<Client> {
    return this.httpClient.post<Client>(this.clientsUrl, client);
  }

  deleteClient(id: number): Observable<Client> {
    const endPoints = '/' + id;
    return this.httpClient.delete<Client>(this.clientsUrl + endPoints);
  }

  updateClient(client: Client) {
    const endPoints = '/' + client.id;
    return this.httpClient.put<Client>(this.clientsUrl + endPoints, client);
  }
}

