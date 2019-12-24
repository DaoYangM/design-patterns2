package top.daoyang.behavioral.commandpattern;

public class TVOpenTVCommand extends TVCommand {

    public TVOpenTVCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.open();
    }
}
