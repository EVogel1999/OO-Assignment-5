package abstracts;

import interfaces.AddOn;
import interfaces.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;
    private AddOn addon;

    public Decorator(Receipt r, AddOn a) {
        trailer = r;
        addon = a;
    }

    protected void callTrailer() {
        trailer.prtReceipt();
    }

    protected AddOn getAddon() {
        return addon;
    }

    public abstract void prtReceipt();
}