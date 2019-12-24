package top.daoyang.behavioral.commandpattern;

public class TVCloseCommand extends TVCommand {

    public TVCloseCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.close();
    }
}
