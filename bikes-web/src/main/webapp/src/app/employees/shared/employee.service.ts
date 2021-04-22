import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "./employee.model";
import {map} from "rxjs/operators";


@Injectable()
export class EmployeeService {
  private employeesUrl = 'http://localhost:8080/api/employees';

  constructor(private httpClient: HttpClient) {
  }

  getEmployees(): Observable<Employee[]> {
    return this.httpClient.get<Array<Employee>>(this.employeesUrl);
  }

  getEmployee(id: number): Observable<Employee> {
    // @ts-ignore
    return this.getEmployees().pipe(
      map(employees => employees.find(employee => employee.id === id)));
  }

}
