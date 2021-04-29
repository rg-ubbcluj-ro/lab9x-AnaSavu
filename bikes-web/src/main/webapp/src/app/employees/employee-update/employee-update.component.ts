import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "../shared/employee.model";
import {EmployeeService} from "../shared/employee.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {
  @Input() employee: Employee = {
    id: 0,
    name: "",
    position: "",
    workedHours: 0
  };
  constructor(private employeeSerivce: EmployeeService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .pipe(switchMap((params: Params) => this.employeeSerivce.getEmployee(+params['id'])))
      .subscribe(employee => this.employee = employee);
  }

  updateEmployee(name: string, position: string, workedHours: string, id: number) {
    const employee: Employee = <Employee> {
      id,
      name,
      position,
      workedHours: +workedHours
    };
    this.employeeSerivce.updateEmployee(employee).subscribe(e1 => console.log('updated employee: ', e1));
  }

  goBack() {
    this.location.back();
  }
}
