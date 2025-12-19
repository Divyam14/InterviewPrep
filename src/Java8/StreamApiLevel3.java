package Java8;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
Flatten List<List<Integer>> into List<Integer>.

Flatten List<String> where each string is comma-separated.

Given Students with List<Subjects>, list all subjects.
 */
public class StreamApiLevel3 {
    public static void main(String[] args) {

        //Flatten List<List<Integer>> into List<Integer>.
        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

        List<Integer> listlist = list.stream().flatMap(List::stream).toList();
        System.out.println(listlist);

        //Flatten List<String> where each string is comma-separated.
        List<String> stringList = List.of("a,b,c", "d,e,f");

        List<String> flatStringList = stringList.stream().flatMap(x -> Stream.of(x.split(","))).toList();
        System.out.println(flatStringList);

//        Given Students with List<Subjects>, list all subjects.
        List<Student> studentList = List.of(
                new Student("di",28,List.of("Science","Maths")),
                new Student("vy",19,List.of("History","Civics"))
        );

        List<String> subjects = studentList.stream().flatMap(
                s -> s.subjects.stream()
        ).toList();
        System.out.println(subjects);

    }

    public static class Student {
        private String name;
        private int age;
        List<String> subjects;

        public Student(String name, int age,List<String> subjects) {
            this.name = name;
            this.age = age;
            this.subjects = subjects;

        }
    }
}
