package top.daoyang.behavioral.statepattern;

public class PowerOffState extends TVState {
    @Override
    void powerOn() {
        System.out.println("Power off To power on");
        super.remoteController.setCurrentState(RemoteController.POWER_ON);
        super.remoteController.powerOn();
    }

    @Override
    void powerOff() {

    }

    @Override
    void play() {

    }

    @Override
    void standby() {

    }
}
