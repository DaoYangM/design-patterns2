package top.daoyang.behavioral.strategypattern;

import java.util.List;

public class StringSortContext {

    private IStringSortStrategy strategy;

    public StringSortContext(IStringSortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> getSortList(List<String> list) {
        return this.strategy.sort(list);
    }
}
