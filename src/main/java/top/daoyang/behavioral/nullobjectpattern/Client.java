package top.daoyang.behavioral.nullobjectpattern;

public class Client {
    public static void main(String[] args) {
        final AbstractGoods goods1 = GoodsFactory.find("001");
        final AbstractGoods goods3 = GoodsFactory.find("003");

        goods1.show();
        goods3.show();
    }
}
