package HomeWork_2_01;

public abstract class Treadmill {

    static void doRun(Moveable user, boolean passed) {
        user.run();
        if (passed) {
            System.out.println("успешно пробежал");
        } else {
            System.out.println("не смог пробежать ");
        }
    }
}



