package top.daoyang.structural.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class HarmfulRubbishFilter implements RubbishFilter {

    @Override
    public List<Rubbish> rubbishFilter(List<Rubbish> rubbishes) {
        List<Rubbish> harmfulRubbish = new ArrayList<>();

        for (Rubbish rubbish : rubbishes) {
            if (rubbish.isHarm())
                harmfulRubbish.add(rubbish);
        }
        return harmfulRubbish;
    }
}
