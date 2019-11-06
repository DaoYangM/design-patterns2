package top.daoyang.structural.filterpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rubbish {

    private String name;

    private boolean isHarm;

    private boolean isRecycled;

    private boolean isDry;

    private boolean isWet;
}
