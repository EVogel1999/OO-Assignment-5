package receipt.addons;

import interfaces.SecondaryHeading;
import receipt.PurchasedItems;

public class HolidayGreeting implements SecondaryHeading {
    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }

    public String getLines() {
        return "* Happy Holidays from Best Buy *\n\n------------------------------------------------------\n";
    }
}