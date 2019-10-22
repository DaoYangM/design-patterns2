package top.daoyang.creational.builderpattern;

import lombok.RequiredArgsConstructor;

/**
 * 包工头类: 负责控制建造房屋的顺序
 */
@RequiredArgsConstructor
public class Contractor {

    private final HouseBuilder houseBuilder;

    // 控制建造顺序
    public House construct() {
        houseBuilder.buildGround();
        houseBuilder.buildCement();
        houseBuilder.buildRoof();

        return houseBuilder.buildHouse();
    }
}
