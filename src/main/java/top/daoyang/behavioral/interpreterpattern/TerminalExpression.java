package top.daoyang.behavioral.interpreterpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminalExpression extends AbstractExpression{

    private int num;

    @Override
    public int interpreter(Context context) {
        return num;
    }
}
