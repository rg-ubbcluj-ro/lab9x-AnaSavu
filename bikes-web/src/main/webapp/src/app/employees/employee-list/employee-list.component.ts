import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../shared/employee.service";
import {Router} from "@angular/router";
import {Employee} from "../shared/employee.model";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  errorMessage = "";
  employees : Array<Employee> = [];
  selectedEmployee : Employee = {
    id: 0,
    name: "",
    position: "",
    workedHours: 0.
  };

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(employees => this.employees = employees);
  }


  getEmployees() {
    this.employeeService.getEmployees().subscribe(
      employees => this.employees = employees,
      error => this.errorMessage = <any>error
    );
  }

  onSelect(employee: Employee): void {
    this.selectedEmployee = employee;
  }

  onDoubleSelect(employee: Employee): void {
    this.selectedEmployee = employee;
    this.router.navigate(['employee/detail', this.selectedEmployee.id]);
  }

  gotoDetail() {
    this.router.navigate(['employee/detail', this.selectedEmployee.id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(() => console.log('deleted employee'));
  }

  updateEmployee() {
    this.router.navigate(['employee/update', this.selectedEmployee.id]);
  }

  sortEmployees() {

  }
}
