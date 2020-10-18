package HomeWork_2_01;

public class Wall implements Passable {

    @Override
    public void overcomeObstacle(Moveable user, boolean passed) {
        user.jump();
        if (passed) {
            System.out.println("успешно преодолел");
        } else {
            System.out.println("не смог преодолеть");
        }
    }
}
