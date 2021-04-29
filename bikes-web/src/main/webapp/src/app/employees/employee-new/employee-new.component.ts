import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../shared/employee.service";
import {Employee} from "../shared/employee.model";
import {Location} from "@angular/common";

@Component({
  selector: 'app-employee-new',
  templateUrl: './employee-new.component.html',
  styleUrls: ['./employee-new.component.css']
})
export class EmployeeNewComponent implements OnInit {

  constructor(private employeeService: EmployeeService, private location: Location) { }

  ngOnInit(): void {
  }

  saveEmployee(name: string, position: string, workedHours: string) {
    const employee: Employee = <Employee>{
      name,
      position,
      workedHours: +workedHours
    };
    this.employeeService.saveEmployee(employee).subscribe(e1 => console.log('saved employee: ', e1));
  }

  goBack() {
    this.location.back();
  }
}
