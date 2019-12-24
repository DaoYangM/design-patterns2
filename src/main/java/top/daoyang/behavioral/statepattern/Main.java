package top.daoyang.behavioral.statepattern;

public class Main {

    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();

        remoteController.powerOn();
        remoteController.play();
        remoteController.standby();
        remoteController.powerOff();
    }
}
