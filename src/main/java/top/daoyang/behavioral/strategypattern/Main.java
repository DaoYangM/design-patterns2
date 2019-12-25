package top.daoyang.behavioral.strategypattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("admin");
        list.add("code-shop");
        list.add("lucy");

        StringSortContext context = new StringSortContext(new IStringSortStrategyReverse());
        List<String> reverseSortedList = context.getSortList(list);
        System.out.println(reverseSortedList);

        StringSortContext context2 = new StringSortContext(new StringSortStrategyNormal());
        List<String> normalSortedList = context2.getSortList(list);
        System.out.println(normalSortedList);
    }
}
