package top.daoyang.structural.compositepattern;

public class TextFile extends File {
    public TextFile(String name, String type) {
        super(name, type);
    }

    @Override
    public void add(File file) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(File file) {
        throw new UnsupportedOperationException();
    }
}
