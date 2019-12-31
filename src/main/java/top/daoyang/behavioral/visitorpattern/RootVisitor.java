package top.daoyang.behavioral.visitorpattern;

public class RootVisitor implements Visitor {
    @Override
    public void visit(FileElement fileElement) {
        System.out.println("Root can access file " + fileElement.getName());
    }

    @Override
    public void visit(FolderElement folderElement) {
        System.out.println("Root can access folder " + folderElement.getName());
    }
}
