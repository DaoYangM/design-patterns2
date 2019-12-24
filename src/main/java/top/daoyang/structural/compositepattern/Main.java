package top.daoyang.structural.compositepattern;

public class Main {

    public static void main(String[] args) {
        File rootFolder = new Folder("root", "folder");

        File etcFolder = new Folder("etc", "folder");
        etcFolder.add(new ImageFile("hello.png", "image"));
        etcFolder.add(new ImageFile("world.png", "image"));

        rootFolder.add(etcFolder);

        File usrFolder = new Folder("usr", "folder");

        File userBinFolder = new Folder("bin", "folder");
        userBinFolder.add(new TextFile("ls", "bin"));

        usrFolder.add(userBinFolder);

        rootFolder.add(usrFolder);

        rootFolder.display(0);
    }
}
