package HomeWork_2_01;

public class Treadmill implements  Passable {

    @Override
    public void overcomeObstacle(Moveable user, boolean passed) {
        user.run();
        if (passed) {
            System.out.println("успешно пробежал");
        } else {
            System.out.println("не смог пробежать ");
        }
    }
}



