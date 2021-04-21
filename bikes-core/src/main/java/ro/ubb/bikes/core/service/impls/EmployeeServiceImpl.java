package ro.ubb.bikes.core.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ubb.bikes.core.model.Employee;
import ro.ubb.bikes.core.model.exceptions.ValidatorException;


import ro.ubb.bikes.core.model.validators.EmployeeValidator;
import ro.ubb.bikes.core.repository.EmployeeJpaRepository;
import ro.ubb.bikes.core.repository.RentalJpaRepository;
import ro.ubb.bikes.core.service.interfaces.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    private RentalJpaRepository rentalJpaRepository;

    @Autowired
    private EmployeeValidator employeeValidator;

    @Override
    public Employee add(Employee entity) throws ValidatorException {
        log.trace("add - method entered: employee={}", entity);

        employeeValidator.validate(entity);
        Employee savedEmployee = employeeJpaRepository.save(entity);

        log.trace("add - method finished: employee={}", savedEmployee);
        return savedEmployee;
    }

    @Override
    public Employee delete(Long id) throws ValidatorException {
        log.trace("delete - method entered: id={}", id);

        Optional<Employee> optionalEmployee = employeeJpaRepository.findById(id);
        optionalEmployee.ifPresentOrElse(
                (employee) -> {
                    employeeJpaRepository.deleteById(employee.getId());
                    log.debug("delete - deleted: employee={}", employee);
                },
                () -> {
                    throw new ValidatorException("Employee - Employee ID not in database");
                }
        );

        log.trace("delete - method finished");
        return optionalEmployee.get();
    }

    @Override
    @Transactional
    public Employee update(Employee entity) throws ValidatorException {
        log.trace("update - method entered: employee={}", entity);
        employeeValidator.validate(entity);

        Employee currentEmployee = employeeJpaRepository
                .findById(entity.getId())
                .orElseThrow(() -> new ValidatorException("UPDATE - Employee not in database"));
        log.trace("update - before update: employee={}", currentEmployee);

        currentEmployee.setName(entity.getName());
        currentEmployee.setPosition(entity.getPosition());
        currentEmployee.setWorkedHours(entity.getWorkedHours());
        log.debug("update - updated: employee={}", currentEmployee);

        log.trace("update - method finished");
        return entity;
    }

    @Override
    public List<Employee> getAll() {
        log.trace("getAll --- method entered");
        List<Employee> employees = employeeJpaRepository.findAll();
        log.trace("getAll: result={}", employees);
        return employees;
    }

    @Override
    public Employee exist(Long id) throws ValidatorException {
        log.trace("exist - method entered: id={}", id);
        Employee employee = employeeJpaRepository
                .findById(id)
                .orElseThrow(() -> new ValidatorException("EXIST - Employee ID not in database"));
        log.trace("exist - method finished: employee found={}", employee);
        return employee;
    }

    @Override
    public List<Employee> filter(int workedHours) {
        log.trace("filter - method entered: workedHours={}", workedHours);
        List<Employee> employees = employeeJpaRepository.findByWorkedHoursEquals(workedHours);
        log.trace("filter: result={}", employees);
        return employees;
    }

    @Override
    public List<Employee> sort() {
        log.trace("sort - method entered");
        List<Employee> employees = employeeJpaRepository.findByOrderByPosition();
        log.trace("sort: result={}", employees);
        return employees;
    }
}
