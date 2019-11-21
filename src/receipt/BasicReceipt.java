package receipt;

import abstracts.TaxComputationMethod;
import interfaces.Receipt;

import java.text.DecimalFormat;
import java.util.Date;

public class BasicReceipt implements Receipt {
    private StoreHeader store_header; // street address, state code, phone number, store number
    private TaxComputationMethod tc;
    private Date date; // may also be a String type
    private PurchasedItems items;

    public BasicReceipt(PurchasedItems items, Date date) { // Date may also be a String type
        this.items = items;
        this.date = date;
    }

    public void setStoreHeader(StoreHeader h) {
        store_header = h;
    }

    public void setTaxComputationMethod(TaxComputationMethod tc) {
        this.tc = tc;
    }

    public void prtReceipt() {
        items.setCurrent(0);
        String str = date + "\n\nITEM #\n\n";
        while (items.hasNext()) {
            StoreItem item = items.next();
            str += item.getItemCode() + " " + item.getItemDescription() + "   $" + item.getItemPrice() + "\n";
        }

        DecimalFormat df = new DecimalFormat("#.##");
        str += "\nTotal Sale                               $" + df.format(items.getTotalCost());
        str += "\n\nSale with Tax " + tc + "             $" + df.format(tc.computeTax(items, date));

        System.out.println(str);
    }
}