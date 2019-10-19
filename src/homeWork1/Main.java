package homeWork1;

public class Main {
    public static void main(String[] args) {

        //TODO 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать
        // (методы просто выводят информацию о действии в консоль).

        Cat cat = new Cat("Fluffy");

        cat.jump();
        cat.run();

        Robot robot = new Robot();


        Bihavior human = new Human("Bob");


        infoJumpRun(cat);
        infoJumpRun(robot);
        infoJumpRun(human);

        ////////
        //TODO 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
        // должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
        // (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина (для дорожки) или высота (для стены),
        // а участников ограничения на бег и прыжки.

        System.out.println("*************");

        Bihavior sportCat = new Cat("Bruce");

        Wall greatWall = new Wall();

        boolean attemptJump = greatWall.jumpThrough(sportCat);

        if (attemptJump) {
            System.out.println(sportCat.getName() + " jumped the wall!");
        } else {
            System.out.println(sportCat.getName() + " failed with jump!");
        }

        RunningTrack track = new RunningTrack();

        boolean attemptRun = track.toGetFinish(sportCat);

        if (attemptRun) {
            System.out.println(sportCat.getName() + " finished track!");
        } else {
            System.out.println(sportCat.getName() + " faild with finishing track!");
        }
        //////////////
        //TODO 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников
        // пройти этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

        System.out.println("*************");

        Bihavior[] challenger = new Bihavior[3];
        challenger[0] = new Cat("Fluffy", 4, 25);
        challenger[1] = new Robot("R2D2", 2, 100);
        challenger[2] = new Human("John Lennon", 3, 10);


        Object[] objects = new Object[10];

        for (int i = 0, k = 0; i < objects.length / 2; i++, k += 2) {
            objects[k] = new Wall(i + 1);
            objects[k + 1] = new RunningTrack("track " + (i + k + 2), i + k + 2);

        }
//        objects[0] = new Wall(2);
//        objects[1] = new RunningTrack("small", 5);
//        objects[2] = new Wall(5);
//        objects[3] = new RunningTrack("middle", 20);


        for (int n = 0; n < objects.length; n++) {

            for (int i = 0; i < challenger.length; i++) {

                if (objects[n] instanceof Wall && challenger[i].isCompete()) {
                    Wall thisWall = (Wall) objects[n];
                    boolean result = thisWall.jumpThrough(challenger[i]);
                    if (result) {
                        System.out.println(challenger[i].getName() + " done wall " + thisWall.getHight() + " m");
                    } else {

                        competeOutMessage(challenger[i]);
                    }
                }

                if (objects[n] instanceof RunningTrack && challenger[i].isCompete()) {
                    RunningTrack thisTrack = (RunningTrack) objects[n];
                    boolean result = thisTrack.toGetFinish(challenger[i]);
                    if (result) {
                        System.out.println(challenger[i].getName() + " done track " + thisTrack.getLength() + " km");
                    } else {
                        competeOutMessage(challenger[i]);
                    }
                }

            }
        }


    }

    private static void infoJumpRun(Bihavior bihavior) {
        bihavior.jump();
        bihavior.run();
        System.out.println();
    }

    private static void competeOutMessage(Bihavior challenger) {
        challenger.setCompete(false);
        System.out.println(challenger.getName() + " failed and he`s out");
    }
}
