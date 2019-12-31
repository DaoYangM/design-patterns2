package top.daoyang.behavioral.visitorpattern;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();

        Visitor root = new RootVisitor();
        computer.showFileAndDict(root);

        NormalVisitor normalVisitor = NormalVisitor.builder()
                .username("normal")
                .group("normal")
                .build();

        computer.showFileAndDict(normalVisitor);
    }
}
