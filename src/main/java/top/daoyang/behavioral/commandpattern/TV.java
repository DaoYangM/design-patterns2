package top.daoyang.behavioral.commandpattern;

/**
 * 动作的执行者
 */
public class TV {

    public void open() {
        System.out.println("TV open");
    }

    public void changeChannel() {
        System.out.println("TV change channel");
    }

    public void close() {
        System.out.println("TV close");
    }
}
