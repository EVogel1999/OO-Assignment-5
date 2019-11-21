package tax;

import abstracts.TaxComputationMethod;
import receipt.PurchasedItems;

import java.util.Date;

public class CATaxComputation extends TaxComputationMethod {
    @Override
    public double computeTax(PurchasedItems items, Date date) {
        // calls private method taxHoliday as part of this computation
        if (taxHoliday(date)) {
            return items.getTotalCost();
        } else {
            double total = items.getTotalCost();
            return total +  (total * .0725);
        }
    }

    @Override
    protected boolean taxHoliday(Date date) {
        return false;
    }

    @Override
    public String toString() {
        return "(CA 7.25% Tax)";
    }
}
