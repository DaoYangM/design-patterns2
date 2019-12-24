package top.daoyang.behavioral.commandpattern;

public class PersonControlTV {

    public void doCommand(TVCommand tvCommand) {
        tvCommand.execute();
    }
}
