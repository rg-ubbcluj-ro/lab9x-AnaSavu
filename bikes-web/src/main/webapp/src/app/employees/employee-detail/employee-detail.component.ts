import {Component, Input, OnInit} from '@angular/core';
import {EmployeeService} from "../shared/employee.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";
import {Employee} from "../shared/employee.model";

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  @Input() employee: Employee = {
    id: 0,
    name: "",
    position: "",
    workedHours: 0.
  };

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.employeeService.getEmployee(+params['id'])))
      .subscribe(employee => this.employee = employee);
  }

  goBack() {
    this.location.back();
  }
}
