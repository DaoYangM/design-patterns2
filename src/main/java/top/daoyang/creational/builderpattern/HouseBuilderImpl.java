package top.daoyang.creational.builderpattern;

/**
 * 负责建造具体的房屋
 */
public class HouseBuilderImpl implements HouseBuilder {

    private House house = new House();

    public void buildRoof() {
        System.out.println("build roof");
        house.setRoof("roof");
    }

    public void buildCement() {
        System.out.println("build cement");
        house.setCement("build cement");
    }

    public void buildGround() {
        System.out.println("build ground");
        house.setGround("build ground");
    }

    public House buildHouse() {
        return house;
    }
}
