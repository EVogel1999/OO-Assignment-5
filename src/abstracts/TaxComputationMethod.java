package abstracts;

import receipt.PurchasedItems;

import java.util.Date;

public abstract class TaxComputationMethod {
    public abstract double computeTax(PurchasedItems items, Date date);
    protected abstract boolean taxHoliday(Date date);
}