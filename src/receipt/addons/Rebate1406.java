package receipt.addons;

import interfaces.Rebate;
import receipt.PurchasedItems;

public class Rebate1406 implements Rebate {

    @Override
    public boolean applies(PurchasedItems items) {
        return items.containsItem("1406");
    }

    public String getLines() {
        return "\n------------------------------------------------------\n\nMail-in Rebate for Item #1406\n" + "Name:\n" + "Address:\n\n" +
                "Mail to: Best Buy Rebates, P.O. Box 1400, Orlando, FL";
    }
}