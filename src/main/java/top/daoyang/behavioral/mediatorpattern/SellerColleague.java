package top.daoyang.behavioral.mediatorpattern;

public class SellerColleague extends Colleague {
    public SellerColleague(MediatorCompany mediatorCompany) {
        super(mediatorCompany);
    }

    @Override
    public void accept(String message) {
        System.out.println("Seller accept: " + message);
    }
}
