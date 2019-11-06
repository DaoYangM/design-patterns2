package top.daoyang.creational.factorypattern;

/**
 * 抽象工厂: 为创建一组相关或相互依赖的对象提供一个接口,
 * 而无需制定它们的具体类型
 * 产品族: Intel CPU, ASUS motherboard      -> Surface
 *         AMD CPU, Gigabyte motherboard   -> MackBook
 * 产品等级: AMD CPU, Intel CPU
 */
public class AbstractFactory {

    interface CPU {
        void run();
    }

    static class AMDCPU implements CPU {

        @Override
        public void run() {
            System.out.println("AMD CPU run");
        }
    }

    static class IntelCPU implements CPU {

        @Override
        public void run() {
            System.out.println("Intel CPU run");
        }
    }

    interface Motherboard {
        void load();
    }

    static class ASUSMotherboard implements Motherboard {

        @Override
        public void load() {
            System.out.println("ASUS mother load");
        }
    }

    static class GigabyteMotherboard implements Motherboard {

        @Override
        public void load() {
            System.out.println("Gigabyte mother load");
        }
    }

    static abstract class AbstractPCFactory {
        protected abstract CPU newCPU();
        protected abstract Motherboard newMotherboard();
        public void ConsistPC() {
            newCPU().run();
            newMotherboard().load();
        }
    }

    /**
     * Surface PC consistence with Intel CPU and ASUS motherboard.
     */
    static class SurfacePCFactory extends AbstractPCFactory {

        @Override
        protected CPU newCPU() {
            return new IntelCPU();
        }

        @Override
        protected Motherboard newMotherboard() {
            return new ASUSMotherboard();
        }
    }

    /**
     * MacBook PC consistence with AMD CPU and Gigabyte motherboard
     */
    static class MacBookPCFactory extends AbstractPCFactory {

        @Override
        protected CPU newCPU() {
            return new AMDCPU();
        }

        @Override
        protected Motherboard newMotherboard() {
            return new GigabyteMotherboard();
        }
    }

    public static void main(String[] args) {
        System.out.println("Surface pc factory working...");
        SurfacePCFactory surfacePCFactory = new SurfacePCFactory();
        surfacePCFactory.ConsistPC();


        System.out.println("MacBook pc factory working...");
        MacBookPCFactory macBookPCFactory = new MacBookPCFactory();
        macBookPCFactory.ConsistPC();
    }
}
