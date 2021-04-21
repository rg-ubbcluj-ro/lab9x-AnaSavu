package ro.ubb.bikes.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.bikes.core.model.Employee;
import ro.ubb.bikes.web.dto.EmployeeDto;

@Component
public class EmployeeConverter extends BaseConverter<Employee, EmployeeDto>{
    @Override
    public Employee convertDtoToModel(EmployeeDto dto){
        var model = new Employee();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setPosition(dto.getPosition());
        model.setWorkedHours(dto.getWorkedHours());
        return model;
    }

    @Override
    public EmployeeDto convertModelToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getPosition(), employee.getWorkedHours());
        dto.setId(employee.getId());
        return  dto;
    }
}
