
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantMenu {
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private double totalPrice = 0.0;

    public void addItem(String item, double price) {
        items.add(item);
        prices.add(price);
        System.out.println(item + " added to menu for Ksh" + price);
    }
    public void listMenu() {
        System.out.println("Foods:");
        for (int i = 0; i < items.size(); i++) {
            if (prices.get(i) > 50) {
                System.out.println((i + 1) + ". " + items.get(i) + " - Ksh" + prices.get(i));
            }
        }
        System.out.println("\nDrinks:");
        for (int i = 0; i < items.size(); i++) {
            if (prices.get(i) <= 50) {
                System.out.println((i + 1) + ". " + items.get(i) + " - Ksh" + prices.get(i));
            }
        }
    }
    
    public void orderFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich food would you like to order? (Enter menu number)");
        int choice = scanner.nextInt();
        if (choice >8 || choice > items.size()) {
            System.out.println("Invalid choice");
            return;
        }
        System.out.println("You ordered " + items.get(choice - 1) + " for Ksh" + prices.get(choice - 1));
        totalPrice += prices.get(choice - 1);
    }

    public void orderDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhich Drink would you like to order? (Enter menu number)");
        int choice = scanner.nextInt();
        if (choice <9 || choice > items.size()) {
            System.out.println("Invalid choice");
            return;
        }
        System.out.println("You ordered " + items.get(choice - 1) + " for Ksh" + prices.get(choice - 1));
        totalPrice += prices.get(choice - 1);
    }

    public void displayTotal() {
        System.out.println("Your total bill is Ksh" + totalPrice);
    }

    public void payViaMobileMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your mobile money number:");
        String mobileMoneyNumber = scanner.nextLine();
        System.out.println("Please enter the amount to pay:");
        double amount = scanner.nextDouble();
        System.out.println("Payment of Ksh" + amount + " successfully made to " + mobileMoneyNumber);
        totalPrice = 0.0;
    }

    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();

        // Add items to menu

    Foods:
        menu.addItem("Matoke", 70.0);
        menu.addItem("Mokimo", 100.0);
        menu.addItem("Rice and Beans", 70.0);
        menu.addItem("Ugali and Sukuma Wiki", 80.0);
        menu.addItem("Fresh fruit salad ", 60.0);
        menu.addItem("Nyama Choma", 150.0);
        menu.addItem("Chapati Beans", 80.0);
        menu.addItem("Pilau", 100.0);
    Drinks:
        menu.addItem("Chai", 20.0);
        menu.addItem("Coffee", 40.0);
        menu.addItem("Fresh juice", 50.0);
        menu.addItem("Mirinda", 35.0);
        menu.addItem("Coca Cola 500ml", 45.0);
        menu.addItem("Water 300ml", 30.0);
        
        

        // Display menu
        menu.listMenu();

        // Order food and drink
        menu.orderFood();
        menu.orderDrink();

        // Display total bill
        menu.displayTotal();

        // Pay via mobile money
        menu.payViaMobileMoney();
    }
}
