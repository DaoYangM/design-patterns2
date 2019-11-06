package top.daoyang.creational.builderpattern;

public class Main {

    public static void main(String[] args) {

        // 客户端类只需要和包工头打交道
        Contractor contractor = new Contractor(new HouseBuilderImpl());
        System.out.println(contractor.construct());
    }
}
