package DesignPatterns.BuilderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {


        User user = new User.UserBuilder()
                .setName("Hello")
                .setAge(100)
                .setEmail("nakbl")
                .setPhone("78999")
                .build();

        System.out.println(user);
    }
}
