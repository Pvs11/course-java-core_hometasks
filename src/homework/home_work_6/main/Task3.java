package homework.home_work_6.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task3 {

    public Method getMethod(Class<?> sampleClass, String methodName, Class<?>[] parameters) throws NoSuchMethodException {
        sampleClass.getDeclaredMethod(methodName).setAccessible(true);
        Method targetMethod = sampleClass.getDeclaredMethod(methodName);
        sampleClass.getDeclaredMethod(methodName).setAccessible(false);
        return targetMethod;
    }

    public void invokeMethod(Method method, Object obj) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        method.invoke(obj);
        method.setAccessible(false);
    }
}
