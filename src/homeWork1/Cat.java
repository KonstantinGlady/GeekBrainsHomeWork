package homeWork1;

public class Cat implements Bihavior {

   private  String name;
   private boolean compete;


    private static final int MAX_JUMP_HEIGHT_DEFAULT = 3;
    private static final int MAX_DISTANCE_RUN_DEFAULT = 10;

    private int height;
    private int maxDistance;

    public Cat(String name, int height, int maxDistance) {
        this.name = name;
        this.height = height;
        this.maxDistance = maxDistance;
        this.compete = true;
    }

    public Cat(String name){
        this(name,MAX_JUMP_HEIGHT_DEFAULT,MAX_DISTANCE_RUN_DEFAULT);
    }

    public boolean isCompete() {
        return compete;
    }

    public void setCompete(boolean compete) {
        this.compete = compete;
    }

    public int getMaxJump() {
        return height;
    }

    @Override
    public int runMaxDistance() {
        return maxDistance;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("cat " + name + " run");
    }

    @Override
    public void jump() {
        System.out.println("cat " + name + " jump");
    }
}
