package receipt;

import java.util.ArrayList;

public class PurchasedItems {
    private ArrayList<StoreItem> items;
    private int current;

    public PurchasedItems() {
        items = new ArrayList();
        current = 0;
    }

    public void addItem(StoreItem item) {
        this.items.add(item);
    }

    public double getTotalCost() {
        double total = 0;
        for (StoreItem item: items) {
            total += Double.parseDouble(item.getItemPrice());
        }
        return total;
    }

    public boolean containsItem(String itemCode) {
        boolean contains = false;
        for (StoreItem item: items) {
            if (item.getItemCode().equals(itemCode)) {
                contains = true;
            }
        }
        return contains;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current < items.size();
    }

    public StoreItem next() {
        return items.get(current++);
    }
}