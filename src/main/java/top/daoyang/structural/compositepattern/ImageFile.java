package top.daoyang.structural.compositepattern;

public class ImageFile extends File {

    public ImageFile(String filename, String type) {
        super(filename, type);
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
