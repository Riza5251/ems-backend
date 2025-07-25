package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build a rest api for creating a employee in the database
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
          EmployeeDto savedemp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedemp, HttpStatus.CREATED);
    }

    //build rest api for finding a employee by id in the database
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getUserById(@PathVariable  Long id)
    {
        EmployeeDto getemp=employeeService.getEmployeeById(id);
         return ResponseEntity.ok(getemp);
    }
    // build rest api for finding the list of all employees
    @GetMapping("/get")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> employees=employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    //build rest api to update the user
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto )
    {
      EmployeeDto updatedemp=   employeeService.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(updatedemp);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpoyee(@PathVariable("id") Long employeeid)
    {
        employeeService.deleteEmployee(employeeid);
        return ResponseEntity.ok("Employee Deleted");
    }


}
