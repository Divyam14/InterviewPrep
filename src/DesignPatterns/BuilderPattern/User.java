package DesignPatterns.BuilderPattern;

public class User {

    private String name;
    private int age;
    private String email;
    private String phone;

    User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String name;
        private int age;
        private String email;
        private String phone;


        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {

            // optional validation
            return new User(this);
        }
    }
}


