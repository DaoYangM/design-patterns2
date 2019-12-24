package top.daoyang.behavioral.statepattern;

public class PlayState extends TVState {
    @Override
    void powerOn() {
    }

    @Override
    void powerOff() {
        System.out.println("Play state To Power off");
        super.remoteController.setCurrentState(RemoteController.POWER_OFF_STATE);
        super.remoteController.powerOff();
    }

    @Override
    void play() {

    }

    @Override
    void standby() {
        System.out.println("Play To Standby");
        super.remoteController.setCurrentState(RemoteController.STANDBY_STATE);
        super.remoteController.standby();
    }
}
