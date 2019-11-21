package receipt.decorators;

import abstracts.Decorator;
import interfaces.AddOn;
import interfaces.Receipt;

public class PreDecorator extends Decorator {

    public PreDecorator(Receipt r, AddOn a) {
        super(r, a);
    }

    public void prtReceipt() {
        System.out.println(getAddon().getLines());
        callTrailer();
    }
}