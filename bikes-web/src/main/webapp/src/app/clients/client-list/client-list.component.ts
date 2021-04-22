import { Component, OnInit } from '@angular/core';
import {Client} from "../shared/client.model";
import {ClientService} from "../shared/client.service";
import {Router} from "@angular/router";
import {Bike} from "../../bikes/shared/bike.model";

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  errorMessage = "";
  clients : Array<Client> = [];
  selectedClient : Client = {
    id: 0,
    name: "",
    age: 0,
    phoneNumber: "",
  };

  constructor(private clientService: ClientService, private router: Router) { }

  ngOnInit(): void {
    this.clientService.getClients().subscribe(clients => this.clients = clients);
  }

  getClients() {
    this.clientService.getClients()
      .subscribe(
        clients => this.clients = clients,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(client: Client): void {
    this.selectedClient = client;
  }

  gotoDetail() {
    this.router.navigate(['client/detail', this.selectedClient.id]);
  }
}
