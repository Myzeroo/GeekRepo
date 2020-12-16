package HomeWork_3_07;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
       TestClass testClass = new TestClass();
       testClass.start(RunClass.class);
    }
}
