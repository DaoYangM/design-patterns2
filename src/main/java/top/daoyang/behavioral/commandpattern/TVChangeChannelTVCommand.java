package top.daoyang.behavioral.commandpattern;

public class TVChangeChannelTVCommand extends TVCommand {

    public TVChangeChannelTVCommand(TV tv) {
        super(tv);
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}
