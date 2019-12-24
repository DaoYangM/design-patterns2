package top.daoyang.behavioral.mediatorpattern;

public class Main {

    public static void main(String[] args) {
        MediatorCompany mediatorCompany = new MediatorCompanyImpl("Shanbey");

        Colleague buyerColleague = new BuyerColleague(mediatorCompany);
        Colleague sellerColleague = new SellerColleague(mediatorCompany);

        mediatorCompany.setBuyer(buyerColleague);
        mediatorCompany.setSeller(sellerColleague);

        sellerColleague.send("I want to sell my house");
        buyerColleague.send("I want to buy a house");
    }
}
