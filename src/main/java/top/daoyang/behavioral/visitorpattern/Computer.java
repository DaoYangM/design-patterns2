package top.daoyang.behavioral.visitorpattern;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Element> elements = new ArrayList<>();

    {
        FileElement fileElement = new FileElement();
        fileElement.setName("test-file");
        fileElement.setOwn("root");
        fileElement.setGroup("root");
        fileElement.setPermission("775");

        elements.add(fileElement);

        FolderElement folderElement = new FolderElement();
        folderElement.setName("/root");
        folderElement.setOwn("root");
        folderElement.setGroup("root");
        folderElement.setPermission("755");

        elements.add(folderElement);
    }

    void showFileAndDict(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
