package homework.home_work_6.test;

import homework.home_work_6.main.Person;
import homework.home_work_6.main.Task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class Task3Demo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Task3 t3 = new Task3();
        Person person = new Person("Alex", 30);

        Class<?>[] param1 = person.getClass().getDeclaredMethod("someAction").getParameterTypes();
        System.out.println(t3.getMethod(person.getClass(), "someAction", param1));


        t3.invokeMethod(person.getClass().getDeclaredMethod("someAction"), person);
    }
}
