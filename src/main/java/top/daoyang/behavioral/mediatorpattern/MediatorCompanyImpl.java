package top.daoyang.behavioral.mediatorpattern;

public class MediatorCompanyImpl extends MediatorCompany {
    public MediatorCompanyImpl(String name) {
        super(name);
    }

    @Override
    void publish(String message, Colleague colleague) {
        if (colleague instanceof BuyerColleague) {
            seller.accept(message);
        } else if (colleague instanceof SellerColleague) {
            buyer.accept(message);
        }
    }
}
