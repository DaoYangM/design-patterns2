package top.daoyang.creational.builderpattern;

/**
 * 房屋建造者接口,负责确定建造房屋的每个部分
 */
public interface HouseBuilder {

    void buildRoof();

    void buildCement();

    void buildGround();

    House buildHouse();
}
