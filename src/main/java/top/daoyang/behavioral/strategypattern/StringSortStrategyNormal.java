package top.daoyang.behavioral.strategypattern;

import java.util.Collections;
import java.util.List;

public class StringSortStrategyNormal implements IStringSortStrategy {
    @Override
    public List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }
}
