package pro.sky.hw2_8.services;

import org.springframework.stereotype.Service;
import pro.sky.hw2_8.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMinSalaryEmployee(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }
    public Employee findMaxSalaryEmployee(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }
    public List<Employee> getAllOfDept(int department) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }
    public Map<Integer, List<Employee>> getAllEmployeesByDept() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    /*public int totalSalaries(int department) {
        int sum = 0;
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department)
                sum += employee.getSalary();
        }
        return sum;
    }
    public double findAverageSalary(int department) {
        int count = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count != 0){
            return  sum / count;
        } else {
            return  0;
        }
    }
    public void indexSalary(double percent, int department) {
        double coeff = 1 + percent / 100;
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * coeff));
            }
        }
    }
    public void printFullInfo(int department) {
        System.out.println("Сотрудники отдела " + department);
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    public void changeDepartment(String fullName, int newDepartment) {
        Employee employee = findEmployeeByFullname(fullName);
        if (employee != null) {
            employee.setDepartment(newDepartment);
        }
    }
    public void printEmployeesByDepartments() {
        for (int department = 1; department <= 5 ; department++) {
            StringBuilder result = new StringBuilder();
            for (Employee employee :employees) {
                if (employee != null && employee.getDepartment() == department) {
                    result.append(employee).append("\n");
                }
            }
            if (result.length() != 0) {
                System.out.println("Сотрудники отдела " + department + "\n" + result);
            }


        }
    }*/
}
