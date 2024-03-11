package pro.sky.hw2_8.model;

import java.beans.Transient;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private  int salary;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Transient
    public String getFirstName() {
        return firstName;
    }

    @Transient
    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return lastName + " " + firstName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getDepartment() == employee.getDepartment() && getSalary() == employee.getSalary() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDepartment(), getSalary());
    }

    @Override
    public String toString() {
        return String.format("Имя: %s %s, Отдел: %d, ЗП: %d", lastName, firstName, department, salary);
    }
}
