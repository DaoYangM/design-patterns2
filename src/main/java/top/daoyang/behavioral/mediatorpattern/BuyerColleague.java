package top.daoyang.behavioral.mediatorpattern;

public class BuyerColleague extends Colleague {
    public BuyerColleague(MediatorCompany mediatorCompany) {
        super(mediatorCompany);
    }

    @Override
    public void accept(String message) {
        System.out.println("Buyer accept message: " + message);
    }
}
