package pro.sky.hw2_8.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;
import pro.sky.hw2_8.exceptions.InvalidFirstNameException;
import pro.sky.hw2_8.exceptions.InvalidLastNameException;
import pro.sky.hw2_8.model.Employee;
import pro.sky.hw2_8.services.EmployeeService;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int department,
                                @RequestParam int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @ExceptionHandler({InvalidFirstNameException.class, InvalidLastNameException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String handleException() {
        return "Некорректное имя и/или фамилия";
    }
}

