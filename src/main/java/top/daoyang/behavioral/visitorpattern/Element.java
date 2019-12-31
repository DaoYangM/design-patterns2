package top.daoyang.behavioral.visitorpattern;

import lombok.Data;

@Data
public abstract class Element {

    protected String name;

    protected String own;

    protected String group;

    protected String permission;

    protected abstract void accept(Visitor visitor);
}
