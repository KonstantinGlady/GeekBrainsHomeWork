package homeWork1;

public class Human implements Bihavior {

    private int height;
    private int maxDistance;
    private boolean compete;

    private static final int MAX_JUMP_HEIGHT_DEFAULT = 1;
    private static final int MAX_DISTANCE_RUN_DEFAULT = 1;

    private String name;

    public Human(String name, int height, int maxDistance) {
        this.height = height;
        this.maxDistance = maxDistance;
        this.compete = true;
        this.name = name;
    }

    public Human(String name) {
        this(name, MAX_JUMP_HEIGHT_DEFAULT, MAX_DISTANCE_RUN_DEFAULT);
    }

    @Override
    public int runMaxDistance() {
        return maxDistance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("human " + name + " run");
    }

    @Override
    public void jump() {
        System.out.println("human " + name + " jump");
    }

    @Override
    public int getMaxJump() {
        return height;
    }

    @Override
    public boolean isCompete() {
        return compete;
    }

    @Override
    public void setCompete(boolean compete) {
        this.compete = compete;
    }
}
