package ro.ubb.bikes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.bikes.core.model.Employee;
import ro.ubb.bikes.core.service.interfaces.EmployeeService;
import ro.ubb.bikes.web.converter.EmployeeConverter;
import ro.ubb.bikes.web.dto.EmployeeDto;
import ro.ubb.bikes.web.dto.EmployeesListDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.trace("addEmployee: dto={}", employeeDto);

        var employee = employeeConverter.convertDtoToModel(employeeDto);
        var addedEmployee = employeeService.add(employee);
        var resultEmployee = employeeConverter.convertModelToDto(addedEmployee);

        log.trace("addEmployee: result={}", resultEmployee);
        return resultEmployee;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        log.trace("deleteEmployee: id={}", id);
        employeeService.delete(id);
        log.trace("deleteEmployee - method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        log.trace("updateEmployee: id={}, dto={}", id, employeeDto);

        var employee = employeeConverter.convertDtoToModel(employeeDto);
        var updatedEmployee = employeeService.update(employee);
        var resultEmployee = employeeConverter.convertModelToDto(updatedEmployee);

        log.trace("updateEmployee: result={}", resultEmployee);
        return resultEmployee;
    }

//    @RequestMapping(value = "/employees")
//    EmployeesListDto getAllEmployees() {
//        return new EmployeesListDto(
//                employeeConverter.convertModelsToDtos(
//                        employeeService.getAll()
//                ));
//    }

    @RequestMapping(value = "/employees")
    List<EmployeeDto> getAllEmployees() {
        return new ArrayList<>(
                employeeConverter.convertModelsToDtos(
                        employeeService.getAll()
                ));
    }

    @RequestMapping(value = "/employees/filter", method = RequestMethod.GET)
    List<EmployeeDto> filterEmployeesByWorkedHours(@RequestParam Integer workedHours) {
        log.trace("filterEmployeesByWorkedHours - method entered: workedHours={}", workedHours);

        List<Employee> employees = employeeService.filter(workedHours);
//        List<EmployeeDto> employeesDtos = employeeConverter.convertModelsToDtos(employees);
//        EmployeesListDto resultEmployees = new EmployeesListDto(employeesDtos);
        List<EmployeeDto> result = new ArrayList<>(employeeConverter.convertModelsToDtos(employees));
        log.trace("filterEmployeeByWorkedHours: result={}", result);
        return result;
    }

    @RequestMapping(value = "/employees/sort", method = RequestMethod.GET)
    List<EmployeeDto> sortEmployeesByPosition() {
        log.trace("sortEmployeesByPosition - method entered");

        List<Employee> employees = employeeService.sort();
//        List<EmployeeDto> employeesDtos = employeeConverter.convertModelsToDtos(employees);
//        EmployeesListDto resultEmployees = new EmployeesListDto(employeesDtos);
        List<EmployeeDto> result = new ArrayList<>(employeeConverter.convertModelsToDtos(employees));
        log.trace("sortEmployeesByPosition: result={}", result);
        return result;
    }
}
