package top.daoyang.structural.compositepattern;

public abstract class File {

    protected String name;

    protected String type;

    public File(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void displayType() {
        System.out.println(type + " " + name);
    }

    public void display(int index) {
        displayIndex(index);
        displayType();
    }

    public void displayIndex(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("--->");
        }
    }

    public abstract void add(File file);

    public abstract void remove(File file);
}
