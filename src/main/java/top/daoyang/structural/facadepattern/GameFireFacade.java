package top.daoyang.structural.facadepattern;

public class GameFireFacade {

    private FireSystem fireSystem;

    private UserSystem userSystem;

    public GameFireFacade(FireSystem fireSystem, UserSystem userSystem) {
        this.fireSystem = fireSystem;
        this.userSystem = userSystem;
    }

    public void fire() {
        fireSystem.fire();
        fireSystem.loadingBullet();

        userSystem.loseBlood();
        userSystem.addPoint();
    }
}
