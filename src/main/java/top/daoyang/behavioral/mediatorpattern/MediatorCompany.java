package top.daoyang.behavioral.mediatorpattern;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class MediatorCompany {

    private final String name;

    protected Colleague seller;

    protected Colleague buyer;

    abstract void publish(String message, Colleague colleague);
}
