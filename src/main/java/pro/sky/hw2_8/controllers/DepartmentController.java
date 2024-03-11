package pro.sky.hw2_8.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw2_8.model.Employee;
import pro.sky.hw2_8.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryEmployee(@RequestParam int department){
        return departmentService.findMinSalaryEmployee(department);
    }
    @GetMapping("/max-salary")
    public Employee findMaxSalaryEmployee(@RequestParam int department){
        return departmentService.findMaxSalaryEmployee(department);
    }
    @GetMapping("/all")
    public List<Employee> getAllOfDept(@RequestParam int department){
        return departmentService.getAllOfDept(department);
    }
    @GetMapping()
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployeesByDept();
    }
}
