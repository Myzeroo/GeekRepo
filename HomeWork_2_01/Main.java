package HomeWork_2_01;

public class Main {
    public static void main(String[] args) {
       Moveable mv1 = new Human(400, 60);
       Moveable mv2 = new Cat(200, 100);
       Moveable mv3 = new Robot(1000, 20);

       Moveable[] arrMov = {mv1, mv2, mv3};

       Passable ps1 = new Treadmill(250);
       Passable ps2 = new Wall(50);

       Passable[] arrPas = {ps1, ps2};

        for (Passable ps: arrPas) {
            for (Moveable mv: arrMov) {
                ps.overcomeObstacle(mv);
            }
        }
    }
}
