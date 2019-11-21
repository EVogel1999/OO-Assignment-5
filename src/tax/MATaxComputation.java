package tax;

import abstracts.TaxComputationMethod;
import receipt.PurchasedItems;

import java.util.Calendar;
import java.util.Date;

public class MATaxComputation extends TaxComputationMethod {
    @Override
    public double computeTax(PurchasedItems items, Date date) {
        // calls private method taxHoliday as part of this computation
        if (taxHoliday(date)) {
            return items.getTotalCost();
        } else {
            double total = items.getTotalCost();
            return total +  (total * .0625);
        }
    }

    @Override
    protected boolean taxHoliday(Date date) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(calendarStart.MONTH, 7);
        calendarStart.set(Calendar.DATE, 10);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.set(Calendar.MONTH, 7);
        calendarEnd.set(Calendar.DATE, 11);

        if (calendarStart.getTime().compareTo(date) >= 0 && calendarEnd.getTime().compareTo(date) <= 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "(MA 6.25% Tax)";
    }
}
