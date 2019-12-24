package top.daoyang.behavioral.nullobjectpattern;

public class GoodsFactory {

    public static AbstractGoods find(final String isbn) {
        AbstractGoods result = null;

        switch (isbn) {
            case "001":
                result = new ConcreteGoods("001", "Java面试全解析", 69.0);
                break;
            case "002":
                result = new ConcreteGoods("002", "MySQL面试经典", 19.0);
                break;
            default:
                result = new NullGoods();
                break;
        }

        return result;
    }
}
