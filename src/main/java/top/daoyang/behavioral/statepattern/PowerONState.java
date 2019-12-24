package top.daoyang.behavioral.statepattern;

public class PowerONState extends TVState {
    @Override
    void powerOn() {

    }

    @Override
    void powerOff() {
        System.out.println("Power on To Power off");
        super.remoteController.setCurrentState(RemoteController.POWER_OFF_STATE);
        super.remoteController.powerOff();
    }

    @Override
    void play() {
        System.out.println("Power on To Play");
        super.remoteController.setCurrentState(RemoteController.PLAY_STATE);
        super.remoteController.play();
    }

    @Override
    void standby() {
        System.out.println("Power on To Standby");
        super.remoteController.setCurrentState(RemoteController.STANDBY_STATE);
        super.remoteController.standby();
    }
}
