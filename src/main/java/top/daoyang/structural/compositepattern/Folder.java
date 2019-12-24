package top.daoyang.structural.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File {
    public Folder(String name, String type) {
        super(name, type);
    }

    private List<File> subFiles = new ArrayList<>();

    @Override
    public void display(int index) {
        super.display(index);
        for (File file : subFiles) {
            file.display(index + 1);
        }
    }

    @Override
    public void add(File file) {
        subFiles.add(file);
    }

    @Override
    public void remove(File file) {
        subFiles.remove(file);
    }
}
