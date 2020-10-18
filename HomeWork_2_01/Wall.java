package HomeWork_2_01;

public class Wall implements Passable {
    private int altitude;

    public Wall(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public void overcomeObstacle(Moveable user) {

        if (user.jump() > altitude) {
            System.out.println("успешно преодолел");
        } else {
            System.out.println("не смог преодолеть");
        }
    }
}
