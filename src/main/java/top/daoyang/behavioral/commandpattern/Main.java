package top.daoyang.behavioral.commandpattern;

public class Main {

    public static void main(String[] args) {
        TV tv = new TV();

        TVCommand tvOpen = new TVOpenTVCommand(tv);
        TVCommand tvChangeChannel = new TVChangeChannelTVCommand(tv);
        TVCommand tvClose = new TVCloseCommand(tv);

        PersonControlTV personControlTV = new PersonControlTV();
        personControlTV.doCommand(tvOpen);
        personControlTV.doCommand(tvChangeChannel);
        personControlTV.doCommand(tvClose);
    }
}
