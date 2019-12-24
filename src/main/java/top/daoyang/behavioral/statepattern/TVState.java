package top.daoyang.behavioral.statepattern;

// 电视机状态
public abstract class TVState {

    protected RemoteController remoteController;

    protected void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    abstract void powerOn();

    abstract void powerOff();

    abstract void play();

    abstract void standby();
}
