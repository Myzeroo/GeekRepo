package HomeWork_2_01;

public class Main {
    public static void main(String[] args) {
       Moveable mv1 = new Human();
       Moveable mv2 = new Cat();
       Moveable mv3 = new Robot();

       Moveable[] arrMov = {mv1, mv2, mv3};

       Passable ps1 = new Treadmill();
       Passable ps2 = new Wall();

       Passable[] arrPas = {ps1, ps2};

        for (Passable ps: arrPas) {
            for (Moveable mv: arrMov) {
                ps.overcomeObstacle(mv, true);
            }
        }
    }
}
