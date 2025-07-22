package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.ResourceNotFoundException;
import net.javaguides.ems_backend.mapper.EmployeeMapper;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl  implements EmployeeService {
     private EmployeeRepository employeeRepository;
   // private EmployeeMapper mapper;
public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee=EmployeeMapper. maptoemployee(employeeDto);
       Employee saveemp =  employeeRepository.save(employee);
      return EmployeeMapper.maptoemployeedto(saveemp);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       Employee employee= employeeRepository.findById(id)
               .orElseThrow(()->
                       new ResourceNotFoundException("employee with this is=d do not exist "+id));
       return EmployeeMapper.maptoemployeedto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.maptoemployeedto(employee)).collect(Collectors.toList());
    }
}
