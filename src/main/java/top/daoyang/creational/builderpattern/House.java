package top.daoyang.creational.builderpattern;

import lombok.Data;

/**
 * 被构建的房屋类, 特点是需要按照特定的初始化顺序
 * ground -> cement -> root
 */
@Data
public class House {

    private String roof;

    private String cement;

    private String ground;

    House() {}
}
