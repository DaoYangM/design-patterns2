package top.daoyang.creationalpattern.factorypattern;

/**
 * 工厂模式: 根据每一种类别创建单独的工厂.
 */
public class FactoryPattern {

    interface Hamburger {
        void consume();
    }

    static class McDonaldHamburger implements Hamburger {

        @Override
        public void consume() {
            System.out.println("McDonal hamburger");
        }
    }

    static class KFCHamBurger implements Hamburger {

        @Override
        public void consume() {
            System.out.println("KFC hamburger");
        }
    }

    interface HamburgerFactory {
        Hamburger produceHamburger();
    }

    static class McDonaldHamburgerFactory implements HamburgerFactory {

        @Override
        public Hamburger produceHamburger() {
            return new McDonaldHamburger();
        }
    }

    static class KFCHamburgerFactory implements HamburgerFactory {

        @Override
        public Hamburger produceHamburger() {
            return new KFCHamBurger();
        }
    }

    public static void main(String[] args) {
        HamburgerFactory mcDonaldHamburgerFactory = new McDonaldHamburgerFactory();
        mcDonaldHamburgerFactory.produceHamburger().consume();

        HamburgerFactory kcfHamburgerFactory = new KFCHamburgerFactory();
        kcfHamburgerFactory.produceHamburger().consume();
    }
}
