package HomeWork_3_07;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException, InvocationTargetException {
        TestClass tc = new TestClass();
        tc.start(RunClass.class);

    }
}
