package HomeWork_3_07;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    public void start(Class cls) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        int beforeCount = 0;
        int afterCount = 0;

        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annot: annotations) {
            if(annot.equals("BeforeSuite")) beforeCount++;
            if(annot.equals("AfterSuite")) afterCount++;
        }
        if(beforeCount > 1 || afterCount > 1) throw new RuntimeException("BeforeSuite или AfterSuite больше чем по одному");

        Method[] methods = cls.getDeclaredMethods();
        for (Method mth: methods) {
            if(mth.getAnnotatedReturnType().equals("BeforeSuite")){
                mth.invoke(cls);
            }
        }

        for (int i = 1; i < 10; i ++){
            for (Method mth: methods) {
                if(mth.getAnnotatedReturnType().equals("Test")){
                     Field field = cls.getDeclaredField("priority");
                     if(i == field.getInt(cls)){
                         mth.invoke(cls);
                     }
                }
            }
        }

        for (Method mth: methods) {
            if(mth.getAnnotatedReturnType().equals("AfterSuite")){
                mth.invoke(cls);
            }
        }

    }
}
