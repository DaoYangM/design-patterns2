package top.daoyang.behavioral.interpreterpattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotTerminalExpression extends AbstractExpression{

    private AbstractExpression left;

    private AbstractExpression right;

    @Override
    public int interpreter(Context context) {
        if (context.getSymbol().equalsIgnoreCase("+")) {
            return left.interpreter(context) + right.interpreter(context);
        }
        return 0;
    }
}
