package ro.ubb.bikes.core.repository;

import ro.ubb.bikes.core.model.Employee;

import java.util.List;

public interface EmployeeJpaRepository extends IRepository<Employee, Long> {
    //methods from JPA:
    //findAll: returns List<Employee>
    //findById: returns Optional<Employee>, found entity or null
    //save: returns Employee
    //deleteById: returns void
    //we don't have an update method -> findById, ifPresent, set wanted parameters

    List<Employee> findByWorkedHoursEquals(int workedHours);
    List<Employee> findByOrderByPosition();

}
