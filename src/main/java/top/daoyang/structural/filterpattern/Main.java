package top.daoyang.structural.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Rubbish> rubbishList = new ArrayList<>();
        rubbishList.add(new Rubbish("果壳", false, false, true, false));
        rubbishList.add(new Rubbish("陶瓷", false, false, true, false));
        rubbishList.add(new Rubbish("菜根菜叶", false, false, false, true));
        rubbishList.add(new Rubbish("果皮", false, false, false, true));
        rubbishList.add(new Rubbish("水银温度计", true, false, false, false));
        rubbishList.add(new Rubbish("电池", true, false, false, false));
        rubbishList.add(new Rubbish("灯泡", true, false, false, false));
        rubbishList.add(new Rubbish("废纸塑料", false, true, false, false));
        rubbishList.add(new Rubbish("金属和布料", false, true, false, false));
        rubbishList.add(new Rubbish("玻璃", false, true, false, false));

        RubbishFilter dryRubbishFilter = new DryRubbishFilter();
        System.out.println(dryRubbishFilter.rubbishFilter(rubbishList));

        RubbishFilter harmfulRubbishFilter = new HarmfulRubbishFilter();
        System.out.println(harmfulRubbishFilter.rubbishFilter(rubbishList));

    }
}
