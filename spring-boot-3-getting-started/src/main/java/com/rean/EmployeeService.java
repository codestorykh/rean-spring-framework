package com.rean;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public Employee createOrUpdate(Employee employee) {
        if(employee.getId() == null){
            employeeRepository.save(employee);
            return employee;
        }
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        if(employeeOptional.isPresent()) {
            Employee employeeInstance = employeeOptional.get();
            employeeInstance.setFirstName(employee.getFirstName());
            employeeInstance.setLastName(employee.getLastName());
            employeeInstance.setEmail(employee.getEmail());
            employeeRepository.save(employeeInstance);
            return employeeInstance;
        }
        // if no data we can response invalid request with employee id {}
        employeeRepository.save(employee);
        return employee;
    }

    public void delete(Long id) throws EmployeeRecordNotFoundException {
       // employeeRepository.deleteById(id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            employeeRepository.delete(employeeOptional.get());
        }else {
            log.info("Employee id {} not found", id);
            throw new EmployeeRecordNotFoundException("Employee id not found");
        }
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll(); // if you have a lot of data you have to custom with pagination
    }

    public Employee findById(Long id) throws EmployeeRecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        log.info("Employee id {} not found", id);
        throw new EmployeeRecordNotFoundException("Employee id not found");
    }

}
