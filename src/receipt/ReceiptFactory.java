package receipt;

import abstracts.Decorator;
import abstracts.TaxComputationMethod;
import interfaces.*;
import receipt.addons.Coupon100Get10Percent;
import receipt.addons.HolidayGreeting;
import receipt.addons.Rebate1406;
import receipt.decorators.PostDecorator;
import receipt.decorators.PreDecorator;
import tax.CATaxComputation;
import tax.MATaxComputation;
import tax.MDTaxComputation;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class ReceiptFactory {
    StoreHeader store_header; // contains street_addr, zip_code, state_code, phone num, store num
    private TaxComputationMethod tax;
    private AddOn[] addOns; // secondary heading, rebate and coupon add-ons (hardcoded here)

    public ReceiptFactory() { // constructor
        // 1. Populates array of TaxComputationMethod objects and array of AddOn objects (as if downloaded from the BestBuy web site).
        addOns = new AddOn[3];
        addOns[0] = new HolidayGreeting();
        addOns[1] = new Coupon100Get10Percent();
        addOns[2] = new Rebate1406();

        // 2. Reads config file to create and save StoreHeader object (store_num, street_addr, etc.) to be used on all receipts.
        store_header = readConfigFile();

        // 3. Based on the state code (e.g., “MD”) creates and stores appropriate StateComputation object to be used on all receipts.
        switch(store_header.getStateCode()) {
            case "MD":
                tax = new MDTaxComputation();
                break;
            case "MA":
                tax = new MATaxComputation();
                break;
            case "CA":
                tax = new CATaxComputation();
                break;
        }
    }

    private StoreHeader readConfigFile() {
        Scanner scanner = null;
        try {
            File file = new File("src/resources/config.txt");
            scanner = new Scanner(file);

            String street = scanner.next();
            String zip = scanner.nextLine();
            String state = scanner.nextLine();
            String phone = scanner.nextLine();
            String store = scanner.nextLine();

            scanner.close();
            return new StoreHeader(street, zip, state, phone, store);
        } catch (Exception e) {
            scanner.close();
            e.printStackTrace();
            // If can't read file, return default Store Header
            return new StoreHeader("123 Main St., SomeTown", "21455", "MD", "410-704-5555", "2014");
        }
    }

    public Receipt getReceipt(PurchasedItems items, Date date) {
        // 1. Sets the current date of the BasicReceipt.
        BasicReceipt receipt = new BasicReceipt(items, date);

        // 2. Sets StoreHeader object of the BasicReceipt (by call to SetStoreHeader of BasicReceipt)
        receipt.setStoreHeader(store_header);

        // 3. Sets the TaxComputationMethod object of the BasicReceipt (by call to the setTaxComputationMethod of BasicReceipt).
        receipt.setTaxComputationMethod(tax);

        // 4. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
        // If of type SecondaryHeader, then creates a PreDecorator for other AddOn. If of type Rebate or Coupon, then creates a PostDecorator.
        // 5. Links in the decorator object based on the Decorator design pattern.
        Decorator decorator = null;

        for (AddOn addOn: addOns) {
            if (addOn instanceof SecondaryHeading && addOn.applies(items)) {
                decorator = new PreDecorator((decorator == null ? receipt : decorator), addOn);
            } else if (addOn.applies(items)) {
                decorator = new PostDecorator((decorator == null ? receipt : decorator), addOn);
            }
        }

        // 6. Returns decorated BasicReceipt object as type Receipt.
        return decorator;
    }
}