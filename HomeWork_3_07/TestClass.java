package HomeWork_3_07;

import HomeWork_3_07.Annotations.AfterSuite;
import HomeWork_3_07.Annotations.BeforeSuite;
import HomeWork_3_07.Annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestClass {

    public void start(Class stClass) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class clClass = Class.forName(stClass.getName());
        Constructor constructor = clClass.getConstructor();
        Object obj1 = constructor.newInstance();

        int beforeCount = 0;
        int afterCount = 0;

        Method[] methods = clClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                beforeCount++;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                afterCount++;
            }
        }
        if (beforeCount > 1 || afterCount > 1) throw new RuntimeException("Неверное количество бефор или афтер");

        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                m.setAccessible(true);
                m.invoke(obj1);
                m.setAccessible(false);
            }
        }
        Map<Integer, Method> orders = new HashMap();
        for (Method m : methods) {
            for (int i = 1; i <= 10; i++) {
                if (m.getAnnotation(Test.class) != null) {
                    if (((Test) m.getAnnotation(Test.class)).priority() == i) {
                        orders.put(i, m);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Method> entry : orders.entrySet()) {
            entry.getValue().setAccessible(true);
            entry.getValue().invoke(obj1);
            entry.getValue().setAccessible(false);
        }
        for (Method m : methods) {
            if (m.getAnnotation(AfterSuite.class) != null) {
                m.setAccessible(true);
                m.invoke(obj1);
                m.setAccessible(false);
            }
        }
    }
}

