package homework.home_work_6.main;

public class Person {
    private static long counter = 0;
    private long id;
    private String name;
    private int age;
    private String passward;
    public Person(String name, int age) {
        this.id = ++counter;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }
    public void setPassword(String newPassword) {
        this.passward = newPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    private void someAction() {
        System.out.println("Method invocation successful");
    }

}
