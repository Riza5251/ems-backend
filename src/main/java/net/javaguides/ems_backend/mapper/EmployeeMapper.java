package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoemployeedto(Employee employee)
    {
        return new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname(), employee.getEmail())
;       }

    public static Employee maptoemployee(EmployeeDto employeeDto)
    {
        return new Employee(employeeDto.getId(), employeeDto.getFirstname(), employeeDto.getLastname(), employeeDto.getEmail());
    }
}
