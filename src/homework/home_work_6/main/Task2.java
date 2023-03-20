package homework.home_work_6.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task2 {
    public Method performAction(Method method, Object obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        method.invoke(obj, method.getParameterTypes());
        return obj.getClass().getMethod(method.getName(), method.getParameterTypes());
    }

    public void refactorField(Field field, Object obj, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field objField = obj.getClass().getDeclaredField(field.getName());
        objField.setAccessible(true);
        objField.set(obj, value);
        objField.setAccessible(false);
    }
}
