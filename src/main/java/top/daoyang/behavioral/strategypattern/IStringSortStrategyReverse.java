package top.daoyang.behavioral.strategypattern;

import java.util.Collections;
import java.util.List;

public class IStringSortStrategyReverse implements IStringSortStrategy {
    @Override
    public List<String> sort(List<String> list) {
        Collections.sort(list);
        Collections.reverse(list);

        return list;
    }
}
