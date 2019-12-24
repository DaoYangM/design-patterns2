package top.daoyang.structural.filterpattern;

public class Rubbish {

    private String name;

    private boolean isHarm;

    private boolean isRecycled;

    private boolean isDry;

    private boolean isWet;

    public Rubbish(String name, boolean isHarm, boolean isRecycled, boolean isDry, boolean isWet) {
        this.name = name;
        this.isHarm = isHarm;
        this.isRecycled = isRecycled;
        this.isDry = isDry;
        this.isWet = isWet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHarm() {
        return isHarm;
    }

    public void setHarm(boolean harm) {
        isHarm = harm;
    }

    public boolean isRecycled() {
        return isRecycled;
    }

    public void setRecycled(boolean recycled) {
        isRecycled = recycled;
    }

    public boolean isDry() {
        return isDry;
    }

    public void setDry(boolean dry) {
        isDry = dry;
    }

    public boolean isWet() {
        return isWet;
    }

    public void setWet(boolean wet) {
        isWet = wet;
    }
}
