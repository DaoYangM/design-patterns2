package top.daoyang.behavioral.templatepattern;

/**
 * 工作抽象类定义模版方法
 */
public abstract class AbstractWork {

    public void gotoWork() {
        getUp();
        eatBreakFirst();
        commute();
        arrive();
    }

    private void getUp() {
        System.out.println("1. Get up");
    }

    public void eatBreakFirst() {
    }

    public abstract void commute();

    public final void arrive() {
        System.out.println("3. Arrive");
    }
}
