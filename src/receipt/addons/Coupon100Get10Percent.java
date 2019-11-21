package receipt.addons;

import interfaces.Coupon;
import receipt.PurchasedItems;

public class Coupon100Get10Percent implements Coupon { // similar to rebate class

    @Override
    public boolean applies(PurchasedItems items) {
        return items.getTotalCost() >= 100;
    }

    @Override
    public String getLines() {
        return "\n------------------------------------------------------\n\nBEST BUY COUPON                  10% off next purchase\nGood until 12/31/2018";
    }
}