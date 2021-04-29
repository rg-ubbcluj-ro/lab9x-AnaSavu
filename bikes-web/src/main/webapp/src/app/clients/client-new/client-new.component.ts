import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {ClientService} from "../shared/client.service";
import {Client} from "../shared/client.model";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-client-new',
  templateUrl: './client-new.component.html',
  styleUrls: ['./client-new.component.css']
})
export class ClientNewComponent implements OnInit {
  // clientForm: FormGroup;
  clientForm = this.fb.group({
    name: ['', Validators.required],
    age: ['', Validators.required],
    phoneNumber: ['', Validators.required]
  });

  constructor(private clientService: ClientService, private location: Location, private fb: FormBuilder) { }

  ngOnInit(): void {

  }

  // saveClient(name: string, age: string, phoneNumber: string) {
  //   const client: Client = <Client>{
  //     name,
  //     age: +age,
  //     phoneNumber
  //   };
  //   this.clientService.saveClient(client).subscribe(c1 => console.log('saved client: ', c1));
  // }

  goBack(): void {
    this.location.back();
  }

  submitClient(clientForm: FormGroup): void {
    const client: Client = <Client>{
      name: clientForm.value.name,
      age: +clientForm.value.age,
      phoneNumber: clientForm.value.phoneNumber
    };
    this.clientService.saveClient(client).subscribe(c1 => console.log('saved client: ', c1));
  }
}
