package src.com.pack.java8;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    public Employee(int id, String name, int age, long salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

class StreamListSorting {

    public static void main(String[] args) {

        // sort employee by salary in ascending order
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(10, "Ramesh", 30, 400000));
        employees.add(new Employee(20, "John", 29, 350000));
        employees.add(new Employee(30, "Tom", 30, 450000));
        employees.add(new Employee(40, "Rahul", 29, 500000));
        employees.add(new Employee(40, "Pramod", 29, 500000));


        // sort employee by salary in ascending order
        List<Employee> emp = employees.stream()
                .sorted(((o1, o2) -> Math.toIntExact(o1.getSalary() - o2.getSalary()))).collect(Collectors.toList());

        //System.out.println(emp);

        // sort employee by salary in ascending order
        List<Employee> emp2 = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList());

        //System.out.println(emp2);

        // sort employee by salary in descending order
        List<Employee> emp3 = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList());

        //System.out.println(emp3);

        // sort by emp salary desc then by name
        List<Employee> emp4 = employees.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .collect(Collectors.toList());

        //System.out.println(emp4);

        // get max salary
        Optional<Employee> maxSalaryEmp =
                employees.stream()
                        .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));

        //System.out.println(maxSalaryEmp);

        //System.out.println(employees.stream().mapToLong(Employee::getSalary).max().getAsLong());

        //get second max salary
        Optional<Employee> secondMaxSalaryEmp = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();

        //System.out.println(secondMaxSalaryEmp.get());

    }
}