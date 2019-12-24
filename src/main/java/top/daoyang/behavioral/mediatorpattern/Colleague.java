package top.daoyang.behavioral.mediatorpattern;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Colleague {

    protected final MediatorCompany mediatorCompany;

    public void send(String message) {
        mediatorCompany.publish(message, this);
    }

    public abstract void accept(String message);
}
