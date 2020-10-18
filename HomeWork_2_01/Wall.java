package HomeWork_2_01;

public abstract class Wall {

    static void doRun(Moveable user, boolean passed) {
        user.jump();
        if (passed) {
            System.out.println("успешно преодолел");
        } else {
            System.out.println("не смог преодолеть");
        }
    }
}
