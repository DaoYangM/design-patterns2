package top.daoyang.behavioral.commandpattern;

public abstract class TVCommand {

    protected TV tv;

    public TVCommand(TV tv) {
        this.tv = tv;
    }

    public abstract void execute();
}
