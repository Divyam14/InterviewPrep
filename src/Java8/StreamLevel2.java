package Java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
Level 2 – Combined Operations

Remove duplicates and sort numbers.

Given Employee objects, collect names.

Check if any employee has salary > X.

Find first element matching a condition.

Generate first 10 even numbers using IntStream.
 */
public class StreamLevel2 {
    public static void main(String[] args) {
//        Remove duplicates and sort numbers.

        List<Integer> list = List.of(75,85,69,88,1,1, 2, 3, 4, 5, 6, 7,7, 8, 9, 10);
        List<Integer> distinctSortedlist = list.stream().distinct().sorted().toList();
        System.out.println(distinctSortedlist);

        // Given Employee objects, collect names.
        List<Employee>  employees = List.of(
                new Employee(1,"divyam",100000),
                new Employee(2,"rad",50000),
                new Employee(5,"employee",70000),
                new Employee(5,"employee",20000)
        );

        List<String> empName = employees.stream().map(x -> x.name).toList();
        System.out.println(empName);

//        Check if any employee has salary > X.
        List<Employee> salaryGreat = employees.stream().filter(x -> x.salary>25000).toList();
        System.out.println(salaryGreat);

        //Find first element matching a condition.
        Employee firstSalaryGreat = employees.stream().filter(x -> x.salary>25000).findFirst().orElse(null);
        System.out.println(firstSalaryGreat);

//        Generate first 10 even numbers using IntStream.
        List<Integer> first10Even = IntStream.iterate(2,x->x+2).limit(10).boxed().toList();
        System.out.println(first10Even);

    }

    public static class Employee {
        int id;
        String name;
        int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
