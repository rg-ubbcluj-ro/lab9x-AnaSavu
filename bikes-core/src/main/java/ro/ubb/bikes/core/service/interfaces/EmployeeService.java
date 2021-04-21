package ro.ubb.bikes.core.service.interfaces;

import ro.ubb.bikes.core.model.Employee;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;

import java.util.List;
import java.util.Set;

public interface EmployeeService extends ServiceCommon<Long, Employee> {

    @Override
    Employee add(Employee entity) throws ValidatorException;

    @Override
    Employee delete(Long id) throws ValidatorException;

    @Override
    Employee update(Employee entity) throws ValidatorException;

    @Override
    List<Employee> getAll();

    @Override
    Employee exist(Long id) throws ValidatorException;

    List<Employee> filter(int workedHours);

    List<Employee> sort();
}
