package homeWork1;

public class RunningTrack implements Obstacle {
    private static final int DISTANCE_OF_THE_TRACK = 5;
    private static final String NAME_BY_DEFAULT = "unknown";
    private String name;
    private int length;

    public RunningTrack(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public RunningTrack(int length) {
        this(NAME_BY_DEFAULT, length);
    }

    public RunningTrack() {
        this(NAME_BY_DEFAULT, DISTANCE_OF_THE_TRACK);
    }

    public boolean toGetFinish(Bihavior bihavior) {
        return (bihavior.runMaxDistance() > length);

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean getObstacle(Bihavior bihavior) {
        return (bihavior.runMaxDistance() > length);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return Integer.toString(length);
    }
}
