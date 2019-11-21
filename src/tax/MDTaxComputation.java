package tax;

import abstracts.TaxComputationMethod;
import receipt.PurchasedItems;

import java.util.Calendar;
import java.util.Date;

public class MDTaxComputation extends TaxComputationMethod {

    public double computeTax(PurchasedItems items, Date date) {
        // calls private method taxHoliday as part of this computation
        if (taxHoliday(date)) {
            return items.getTotalCost();
        } else {
            double total = items.getTotalCost();
            return total +  (total * .06);
        }
    }

    /**
     * returns true if date of receipt within the state’s tax free holiday,
     * else returns false. Supporting method of method computeTax.
     * @param date the date of the purchase
     * @return boolean if it is a tax holiday
     */
    protected boolean taxHoliday(Date date) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.set(calendarStart.MONTH, 7);
        calendarStart.set(Calendar.DATE, 14);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.set(Calendar.MONTH, 7);
        calendarEnd.set(Calendar.DATE, 20);

        if (calendarStart.getTime().compareTo(date) >= 0 && calendarEnd.getTime().compareTo(date) <= 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "(MD 6.00% Tax)";
    }
}