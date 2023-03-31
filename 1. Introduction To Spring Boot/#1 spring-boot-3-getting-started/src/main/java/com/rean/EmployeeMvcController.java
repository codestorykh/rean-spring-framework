package com.rean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/"})
public class EmployeeMvcController {

    private final EmployeeService employeeService;

    @RequestMapping
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String edit(Model model, @PathVariable("id") Optional<Long> id) throws EmployeeRecordNotFoundException {
        if(id.isPresent()) {
            Employee employee = employeeService.findById(id.get());
            model.addAttribute("employee", employee);
        }else {
            model.addAttribute("employee", new Employee());
        }
        return "add-edit-employee";
    }
    @RequestMapping(path = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) throws EmployeeRecordNotFoundException {
        employeeService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdate(Employee employee) {
        employeeService.createOrUpdate(employee);
        return "redirect:/";
    }
}
