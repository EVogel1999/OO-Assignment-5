package interfaces;

import receipt.PurchasedItems;

public interface AddOn { // the type of added info to a BasicReceipt (e.g., greetings, rebates, coupons)
    public boolean applies(PurchasedItems items);
    public String getLines();
}