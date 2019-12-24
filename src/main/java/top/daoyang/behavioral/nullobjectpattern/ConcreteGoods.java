package top.daoyang.behavioral.nullobjectpattern;

public class ConcreteGoods extends AbstractGoods {

    public ConcreteGoods(String isbn, String name, Double price) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
    }

    @Override
    public void show() {
        System.out.println("Goods name: " + name + ", price: " + price);
    }
}
