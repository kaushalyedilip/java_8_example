package example;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingDouble;

public class GroupByExample {

    public static void main(String[] args) {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Aurangabad", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Pune", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Nagar", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Nasik", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        //maxSalary(employeeList);
        //minSalary(employeeList);
        //sumSalary(employeeList);
        averageSalary(employeeList);
    }

    public static void maxSalary(List<Employee> employeeList) {
        Optional<Employee> employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary));

        System.out.println("Max Salary: "+employee.get().getSalary());
    }

    public static void minSalary(List<Employee> employeeList) {
        Optional<Employee> employee = employeeList.stream().min(Comparator.comparing(Employee::getSalary));

        System.out.println("Max Salary: "+employee.get().getSalary());
    }

    public static void sumSalary(List<Employee> employeeList) {
        double salary = employeeList.stream().collect(summingDouble(Employee::getSalary));;

        System.out.println("Sum of Salary: "+salary);
    }

    public static void averageSalary(List<Employee> employeeList) {
        double avgSalary = employeeList.stream().collect(averagingDouble(Employee::getSalary));;

        System.out.println("Sum of Salary: "+avgSalary);
    }
}
