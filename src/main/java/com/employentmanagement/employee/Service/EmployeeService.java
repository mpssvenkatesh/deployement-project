package com.employentmanagement.employee.Service;

import com.employentmanagement.employee.Entity.Employee;
import com.employentmanagement.employee.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public void deleteemployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getbyid(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getallemployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(long id, Employee nEmployeeData) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        existingEmployee.setName(nEmployeeData.getName());
        existingEmployee.setEmail(nEmployeeData.getEmail());
        existingEmployee.setPhone(nEmployeeData.getPhone());
        existingEmployee.setDepartment(nEmployeeData.getDepartment());

        return employeeRepository.save(existingEmployee);
    }


}