package top.daoyang.behavioral.interpreterpattern;

public class Main {

    public static void main(String[] args) {
        Context context = new Context("+");

        AbstractExpression left = new TerminalExpression(1);
        AbstractExpression right = new TerminalExpression(2);

        AbstractExpression calculator = new NotTerminalExpression(left, right);
        System.out.println(calculator.interpreter(context));
    }
}
