package top.daoyang.behavioral.visitorpattern;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NormalVisitor implements Visitor {

    private String username;

    private String group;

    @Override
    public void visit(FileElement fileElement) {
        if (fileElement.getOwn().equalsIgnoreCase(username)) {
            System.out.println(username + " can access file " + fileElement.getName());
        } else {
            System.out.println("Access Deny");
        }
    }

    @Override
    public void visit(FolderElement folderElement) {
        if (folderElement.getOwn().equalsIgnoreCase(username)) {
            System.out.println(username + " can access folder " + folderElement.getName());
        } else {
            System.out.println("Access Deny");
        }
    }
}
