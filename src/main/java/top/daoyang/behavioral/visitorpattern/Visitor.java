package top.daoyang.behavioral.visitorpattern;

public interface Visitor {

    void visit(FileElement fileElement);

    void visit(FolderElement folderElement);
}
