package example;

import beans.Employee;
import beans.EmployeeNew;

import java.util.*;
import java.util.stream.Collectors;

//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
public class CaseStudy {

    static List<EmployeeNew> employeeList = new ArrayList<>();

    static {
        employeeList.add(new EmployeeNew(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new EmployeeNew(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new EmployeeNew(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new EmployeeNew(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new EmployeeNew(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new EmployeeNew(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new EmployeeNew(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new EmployeeNew(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new EmployeeNew(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new EmployeeNew(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new EmployeeNew(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new EmployeeNew(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new EmployeeNew(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new EmployeeNew(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new EmployeeNew(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new EmployeeNew(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new EmployeeNew(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    public static void main(String[] args) {
        //countByGender();
        //printOrganizationName();
        //averageAgeByGender();
        //getHighestPaidEmployee();
        //getEmployeesFilterByJoining();
        //countTheEmployeesByDepartment();
        //averageSalByDepartment();
        //getYoungestEmployee();
        //getHighestExpEmployee();
        //getMaleFemaleEmployees();
        //averageSalaryByGender();
        //getEmployeesByDepartment();
        //getAvgAndTotSal();
        //separateEmployees();
        oldestEmployees();
    }

    /*
    How many male and female employees are there in the organization?
     */
    public static void countByGender() {
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
    }

    /*
     Print the name of all departments in the organization?
     */
    public static void printOrganizationName() {
        employeeList.stream().map(EmployeeNew::getDepartment).distinct().forEach(System.out::println);
    }

    /*
    Query 3.3 : What is the average age of male and female employees?
     */
    public static void averageAgeByGender() {
        Map<String, Double> map = employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getGender,
                Collectors.averagingInt(EmployeeNew::getAge)));
        System.out.println(map);
    }

    /*
    Query 3.4 : Get the details of highest paid employee in the organization?
     */
    public static void getHighestPaidEmployee() {
        Optional<EmployeeNew> employee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(EmployeeNew::getSalary)));
        System.out.println(employee.get());
    }

    /*
    Query 3.5 : Get the names of all employees who have joined after 2015?
     */
    public static void getEmployeesFilterByJoining() {
        employeeList.stream()
                .filter(x -> x.getYearOfJoining() > 2015)
                .map(EmployeeNew::getName)
                .forEach(System.out::println);
        // System.out.println(employeeNewList);
        //employeeNewList.stream().forEach(System.out::println);
    }

    /*
    Query 3.6 : Count the number of employees in each department?
     */
    public static void countTheEmployeesByDepartment() {
        Map<String, Long> empMap = employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getDepartment, Collectors.counting()));
        System.out.println(empMap);
    }

    /*
    Query 3.7 : What is the average salary of each department?
     */
    public static void averageSalByDepartment() {
        Map<String, Double> empMap = employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getDepartment, Collectors.averagingDouble(EmployeeNew::getSalary)));
        System.out.println(empMap);
    }

    /*
    Query 3.8 : Get the details of youngest male employee in the product development department?
     */
    public static void getYoungestEmployee() {
        Optional<EmployeeNew> employeeNew = employeeList.stream().filter(e -> "Male".equals(e.getGender()) && "Product Development".equals(e.getDepartment()))
                .min(Comparator.comparingInt(EmployeeNew::getAge));
        System.out.println(employeeNew.get());
    }

    /*
    Query 3.9 : Who has the most working experience in the organization?
     */
    public static void getHighestExpEmployee() {
        Optional<EmployeeNew> employeeNewOptional = employeeList.stream().min(Comparator.comparingInt(EmployeeNew::getYearOfJoining));
        System.out.println(employeeNewOptional.get());
    }

    /*
    Query 3.10 : How many male and female employees are there in the sales and marketing team?
     */
    public static void getMaleFemaleEmployees() {
        Map<String, Long> empMap = employeeList.stream().filter(x -> "Sales And Marketing".equals(x.getDepartment())).collect(Collectors.groupingBy(EmployeeNew::getGender, Collectors.counting()));
        System.out.println(empMap);
    }

    /*
    Query 3.11 : What is the average salary of male and female employees?
     */
    public static void averageSalaryByGender() {
        Map<String, Double> empMap = employeeList.stream()
                .collect(Collectors.groupingBy(EmployeeNew::getGender,
                        Collectors.averagingDouble(EmployeeNew::getSalary)));
        System.out.println(empMap);
    }

    /*
        Query 3.12 : List down the names of all employees in each department?
     */
    public static void getEmployeesByDepartment() {
        Map<String, List<EmployeeNew>> empMap = employeeList.stream().collect(Collectors.groupingBy(EmployeeNew::getDepartment));

        for (Map.Entry<String, List<EmployeeNew>> entry : empMap.entrySet()) {
            System.out.println("----Employee in " + entry.getKey() + " department------");
            for (EmployeeNew emp : entry.getValue()) {
                System.out.println(emp.getName());
            }
        }
    }

    /*
    Query 3.13 : What is the average salary and total salary of the whole organization?
     */
    public static void getAvgAndTotSal() {
        /*Double avgSal = employeeList.stream().collect(Collectors.averagingDouble(EmployeeNew::getSalary));
        System.out.println("Average Sal:"+avgSal);

        Double sumSalary = employeeList.stream().collect(Collectors.summingDouble(EmployeeNew::getSalary));
        System.out.println(sumSalary);*/
        DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(EmployeeNew::getSalary));
        System.out.println("Avg Sal: " + employeeSalaryStatistics.getAverage());
        System.out.println("Sum Sal: " + employeeSalaryStatistics.getSum());
    }

    /*
    Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
     */
    public static void separateEmployees() {
        Map<Boolean, List<EmployeeNew>> empMap = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        for (Map.Entry<Boolean, List<EmployeeNew>> entry : empMap.entrySet()) {
            if(entry.getKey()) {
                System.out.println("Employees greater than 25");
                for(EmployeeNew emp: entry.getValue()) {
                    System.out.println(emp.getName());
                }
            } else {
                System.out.println("Employees greater less than or equal 25");
                for(EmployeeNew emp: entry.getValue()) {
                    System.out.println(emp.getName());
                }
            }
        }
        System.out.println();
    }

    /*\
    Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
     */
    public static void oldestEmployees() {
        Optional<EmployeeNew> emp =employeeList.stream().max(Comparator.comparingInt(EmployeeNew::getAge));
        System.out.println("Age: "+emp.get().getAge());
        System.out.println("Department: "+emp.get().getDepartment());
    }

}
