package top.daoyang.behavioral.templatepattern;

public class Main {

    public static void main(String[] args) {
        AbstractWork walkToWalk = new WalkToWorkImpl();
        walkToWalk.gotoWork();
    }
}
