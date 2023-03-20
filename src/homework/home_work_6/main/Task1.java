package homework.home_work_6.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task1 {

    public Field getFieldFromClass(Class<?> sampleClass, String fieldName) throws NoSuchFieldException {
        return sampleClass.getDeclaredField(fieldName);
    }

    public Method getMethodFromClass(Class<?> sampleClass, String methodName) throws NoSuchMethodException {
        Method targetMethod = null;
        for (Method method : sampleClass.getMethods()) {
            if (methodName.equals(method.getName())) {
                targetMethod = method;
            }
        }
        Class<?>[] methodParameters = targetMethod.getParameterTypes();
        return sampleClass.getDeclaredMethod(methodName, methodParameters);
    }

    public Method[] getAllMethodsFromClass(Class<?> sampleClass) {
        return sampleClass.getMethods();
    }


}
