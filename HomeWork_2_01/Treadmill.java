package HomeWork_2_01;

public class Treadmill implements Passable {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcomeObstacle(Moveable user) {

        if (user.run() > distance) {
            System.out.println("успешно пробежал");
        } else {
            System.out.println("не смог пробежать ");
        }
    }
}



