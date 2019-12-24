package top.daoyang.behavioral.statepattern;

public class RemoteController {

    public static final TVState STANDBY_STATE = new StandByState();

    public static final TVState POWER_OFF_STATE = new PowerOffState();

    public static final TVState PLAY_STATE = new PlayState();

    public static final TVState POWER_ON = new PowerONState();

    private TVState currentState;

    public RemoteController() {
        currentState = POWER_OFF_STATE;
        currentState.setRemoteController(this);
    }

    public TVState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(TVState tvState) {
        this.currentState = tvState;
        this.currentState.setRemoteController(this);
    }

    public void powerOn() {
        this.currentState.powerOn();
    }

    public void powerOff() {
        this.currentState.powerOff();
    }

    public void play() {
        this.currentState.play();
    }

    public void standby() {
        this.currentState.standby();
    }
}
