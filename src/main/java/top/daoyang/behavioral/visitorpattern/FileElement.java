package top.daoyang.behavioral.visitorpattern;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FileElement extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
