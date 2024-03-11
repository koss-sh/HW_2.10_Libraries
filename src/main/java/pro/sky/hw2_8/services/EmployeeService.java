package pro.sky.hw2_8.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.hw2_8.exceptions.EmployeeAlreadyAddedException;

import pro.sky.hw2_8.exceptions.EmployeeNotFoundException;
import pro.sky.hw2_8.exceptions.EmployeeStorageIsFullException;
import pro.sky.hw2_8.exceptions.InvalidFirstNameException;
import pro.sky.hw2_8.exceptions.InvalidLastNameException;
import pro.sky.hw2_8.model.Employee;


import java.util.*;

@Service
public class EmployeeService {
    private final ValidatorService validatorService;
    private final int SIZE = 10;
    private Map<String, Employee> employees = new HashMap<>(SIZE);

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }


    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(validatorService.validateFirstName(firstName),
                validatorService.validateLastName(lastName),
                department, salary);
        if (employees.size() < SIZE) {
            if (employees.containsKey(employee.getName())) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.put(employee.getName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getName());
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
