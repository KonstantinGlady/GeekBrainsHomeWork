package homeWork1;

public class Wall implements Obstacle{

    private String name = "Wall";
    private static final int HEIGHT_BY_DEFAULT = 4;
    private int hight;

    public Wall(int hight) {
        this.hight = hight;
    }

    public Wall() {
        this(HEIGHT_BY_DEFAULT);
    }

    public boolean jumpThrough(Bihavior bihavior) {
        return (bihavior.getMaxJump() > hight);

    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }


    @Override
    public boolean getObstacle(Bihavior bihavior) {
        return (bihavior.getMaxJump() > hight);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return Integer.toString(hight);
    }
}
