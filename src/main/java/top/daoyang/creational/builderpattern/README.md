# 建造者模式 (Builder Pattern)

建造者模式将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

## 适用场景

- 需要生成的对象具有复杂的内部结构
- 需要生成的对象内部属性本身相互依赖
- 对象的创建过程独立于创建该对象的部件

## 角色

- **Product（产品）**: 被构建的复杂对象，如 `House`
- **Builder（抽象建造者）**: 为创建一个产品对象的各个部件指定抽象接口，如 `HouseBuilder`
- **ConcreteBuilder（具体建造者）**: 实现抽象建造者接口，构建和装配各个部件，如 `HouseBuilderImpl`
- **Director（指挥者）**: 负责安排复杂对象的建造顺序，如 `Contractor`
- **Client（客户端）**: 使用指挥者来创建产品对象

## 示例说明

本示例通过 `Contractor` 控制 `HouseBuilderImpl` 按照 `ground -> cement -> roof` 的顺序建造房屋，最终返回构建好的 `House` 对象。
