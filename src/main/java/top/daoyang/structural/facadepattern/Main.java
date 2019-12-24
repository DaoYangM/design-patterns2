package top.daoyang.structural.facadepattern;

/**
 * 通过门面类，来统一调用复杂的子系统方法，只暴露单一接口给客户端
 */
public class Main {
    public static void main(String[] args) {
        GameFireFacade gameFireFacade = new GameFireFacade(new FireSystem(), new UserSystem());
        gameFireFacade.fire();
    }
}
