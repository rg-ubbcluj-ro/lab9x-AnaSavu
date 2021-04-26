import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {ClientService} from "../shared/client.service";
import {Client} from "../shared/client.model";

@Component({
  selector: 'app-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {

  constructor(private clientService: ClientService, private location: Location) { }

  ngOnInit(): void {
  }

  saveClient(name: string, age: string, phoneNumber: string) {
    const client: Client = <Client>{
      name,
      age: +age,
      phoneNumber
    };
    this.clientService.saveClient(client).subscribe(c1 => console.log('saved client: ', c1));
  }

  goBack() {
    this.location.back();
  }
}
