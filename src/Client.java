import interfaces.Receipt;
import receipt.PurchasedItems;
import receipt.ReceiptFactory;
import receipt.StoreItem;

import java.util.Date;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceiptFactory factory = new ReceiptFactory();
        Date date = new Date();
        PurchasedItems items = new PurchasedItems();

        boolean quit = false;

        while (!quit) {
            printMenu();
            String input = scanner.next();

            switch (input) {
                case "1":
                    date = getDate(scanner);
                    items = new PurchasedItems();
                    break;
                case "2":
                    items = getPurchasedItems(scanner);
                    break;
                case "3":
                    factory.getReceipt(items, date).prtReceipt();
                    break;
                case "4":
                    quit = true;
                    break;
                default:
                    System.out.println("Could not verify command... please try again");
                    break;
            }
        }




//        // 1. Creates a Date object (either from Java API or date entered by user)
//        Date date = getDate(scanner);
//
//        // 2. Creates a PurchasedItems object (selections made by user)
//        //    Prompts user for items to purchase, storing each in PurchasedItems.
//        PurchasedItems items = getPurchasedItems(scanner);
//
//        // 3. Constructs a ReceiptFactory object.
//        ReceiptFactory factory = new ReceiptFactory();
//
//        // 4. Calls the getReceipt method of the factory to obtain constructed receipt.
//        Receipt receipt = factory.getReceipt(items, date);
//
//        // 5. Prints receipt by call to method prtReceipt.
//        System.out.println("\n");
//        receipt.prtReceipt();

        // get receipt date
        // (prompt user for current date)
        // display all available store items to user (to be implemented)
        // get all user selections (to be implemented)

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n-------- Menu --------\n1 - Start New Receipt\n2 - Add Items\n3 - Display Receipt\n4 - Quit\n");
    }

    private static PurchasedItems getPurchasedItems(Scanner scanner) {
        String input = "";
        PurchasedItems items = new PurchasedItems();

        System.out.println("Add a Store Item? (Y/N)");
        input = scanner.next();
        while (input.equals("Y")) {
            System.out.println("\nEnter the Item Num: ");
            String num = scanner.next();
            System.out.println("Enter the Item Description: ");
            String desc = scanner.next();
            System.out.println("Enter the Item Price: ");
            String price = scanner.next();

            items.addItem(new StoreItem(num, desc, price));
            System.out.println("Continue Adding Store Items? (Y/N)");
            input = scanner.next();
        }

        return items;
    }

    private static Date getDate(Scanner scanner) {
        String input = "";
        Date date = new Date();

        System.out.println("Enter a Date? (Y/N)");
        input = scanner.next();
        if (input.equals("Y")) {
            System.out.println("Enter the Day: ");
            int day = scanner.nextInt();
            System.out.println("Enter the Month: ");
            int month = scanner.nextInt();
            System.out.println("Enter the Year: ");
            int year = scanner.nextInt();

            date.setDate(day);
            date.setMonth(month);
            date.setYear(year);
        }

        return date;
    }
}
