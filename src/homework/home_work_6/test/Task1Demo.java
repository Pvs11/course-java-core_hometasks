package homework.home_work_6.test;

import homework.home_work_6.main.Person;
import homework.home_work_6.main.Task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task1Demo {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        Person person = new Person("Alex", 30);
        person.setPassword("123456789");
        Task1 t1 = new Task1();
        Field field = t1.getFieldFromClass(person.getClass(), "passward");
        field.setAccessible(true);
        System.out.println(field.get(person));

        Method method = t1.getMethodFromClass(person.getClass(), "getId");
        Method[] methods = t1.getAllMethodsFromClass(person.getClass());
    }
}
