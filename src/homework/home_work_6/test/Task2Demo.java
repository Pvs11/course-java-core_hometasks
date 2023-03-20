package homework.home_work_6.test;

import homework.home_work_6.main.Person;
import homework.home_work_6.main.Task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task2Demo {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person("Alex", 30);
        Task2 t2 = new Task2();

        Method method = person.getClass().getMethod("someAction");
        t2.performAction(method, person);

        Field fieldToChange = person.getClass().getDeclaredField("name");
        t2.refactorField(fieldToChange, person, "John");
        System.out.println(person);
    }
}
