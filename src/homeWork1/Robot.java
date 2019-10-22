package homeWork1;

public class Robot implements Bihavior {

    private int height;
    private int maxDistance;
    private boolean compete;

    private static final int MAX_JUMP_HEIGHT_DEFAULT = 1;
    private static final int MAX_DISTANCE_RUN_DEFAULT = 1;

    public static final String DEFAULT_NAME = "Bander";
    private String name;

    public Robot(String name,int height, int maxDistance) {
        this.name = name;
        this.height = height;
        this.maxDistance = maxDistance;
        this.compete = true;
    }
    public Robot(){
    this(DEFAULT_NAME,MAX_JUMP_HEIGHT_DEFAULT,MAX_DISTANCE_RUN_DEFAULT);


    }

    @Override
    public void run() {
        System.out.println("robot " + name + " run");

    }

    @Override
    public void jump() {
        System.out.println("robot " + name + " jump");
    }

    @Override
    public int getMaxJump() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int runMaxDistance() {
        return maxDistance;
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
