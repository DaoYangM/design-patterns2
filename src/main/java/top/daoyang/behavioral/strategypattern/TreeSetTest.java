package top.daoyang.behavioral.strategypattern;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

        treeSet.add("lily");
        treeSet.add("yerkim");
        treeSet.add("admin");

        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
