package top.daoyang.behavioral.statepattern;

public class StandByState extends TVState {
    @Override
    void powerOn() {
        System.out.println("Has already power on");
    }

    @Override
    void powerOff() {
        System.out.println("StandBy To Power off...");
        super.remoteController.setCurrentState(RemoteController.POWER_OFF_STATE);
        super.remoteController.powerOff();
    }

    @Override
    void play() {
        System.out.println("StandBy To Play...");
        super.remoteController.setCurrentState(RemoteController.PLAY_STATE);
        super.remoteController.play();
    }

    @Override
    void standby() {
    }
}
