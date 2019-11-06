package top.daoyang.structural.bridgepattern;

/**
 * 类功能层次结构上层: 通常做为抽象类, 类部关联类实现层次结构
 * 抽象手机 关联 软件接口
 */
public abstract class MobilePhoneAbstract {
    protected SoftWare softWare;

    public MobilePhoneAbstract(SoftWare softWare) {
        this.softWare = softWare;
    }

    protected abstract void powerOn();

    protected void runSoftWare() {
        softWare.launch();
    }
}
