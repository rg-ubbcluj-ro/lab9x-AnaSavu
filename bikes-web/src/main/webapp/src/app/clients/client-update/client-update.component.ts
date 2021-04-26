import {Component, Input, OnInit} from '@angular/core';
import {Client} from "../shared/client.model";
import {ClientService} from "../shared/client.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-client-update',
  templateUrl: './client-update.component.html',
  styleUrls: ['./client-update.component.css']
})
export class ClientUpdateComponent implements OnInit {
  @Input() client: Client = {
    id: 0,
    name: "",
    age: 0,
    phoneNumber: ""
  };

  constructor(private clientService: ClientService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.clientService.getClient(+params['id'])))
      .subscribe(client => this.client = client);
  }

  updateClient(name: string, age: string, phoneNumber: string, id: number) {
    const client: Client = <Client>{
      id,
      name,
      age: +age,
      phoneNumber
    };
    this.clientService.updateClient(client).subscribe(c1 => console.log('updated client: ', c1));
  }

  goBack() {
    this.location.back();
  }
}
