package com.employentmanagement.employee.Controller;


import com.employentmanagement.employee.Entity.Employee;
import com.employentmanagement.employee.Service.EmployeeService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Data
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addemployee")
    public Employee addemployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity deleteemployee(@PathVariable long id) {
        Employee employee1 = employeeService.getbyid(id);
        employeeService.deleteemployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/allemployees")
    public List<Employee> getallemployees() {
        return employeeService.getallemployees();
    }

    @GetMapping("/getbyid/{id}")
    public Employee getbyid(@PathVariable long id) {
        return employeeService.getbyid(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id, @RequestBody Employee nEmployeeData) {
        Employee updatedEmployee = employeeService.updateEmployee(id, nEmployeeData);

        if (updatedEmployee == null) {
            return ResponseEntity.ok("Employee not found");
        }
        return ResponseEntity.ok("Employee updated successfully");
    }


}
