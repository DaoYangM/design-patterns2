package top.daoyang.structural.filterpattern;

import java.util.ArrayList;
import java.util.List;

public class DryRubbishFilter implements RubbishFilter {

    @Override
    public List<Rubbish> rubbishFilter(List<Rubbish> rubbishes) {
        List<Rubbish> dryRubbish = new ArrayList<>();
        for (Rubbish rubbish : rubbishes) {
            if (rubbish.isDry())
                dryRubbish.add(rubbish);
        }
        return dryRubbish;
    }
}
