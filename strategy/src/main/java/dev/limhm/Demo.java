package dev.limhm;

import dev.limhm.order.Order;
import dev.limhm.strategies.PayByCreditCard;
import dev.limhm.strategies.PayByPayPal;
import dev.limhm.strategies.PayStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * World first console e-commerce application.
 */
public class Demo {

  private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Order order = new Order();
  private static PayStrategy strategy;

  static {
    priceOnProducts.put(1, 2200);
    priceOnProducts.put(2, 1850);
    priceOnProducts.put(3, 1100);
    priceOnProducts.put(4, 890);
  }

  public static void main(String[] args) throws Exception {

    while (!order.isClosed()) {
      int cost;

      String continueChoice;
      do {
        System.out.println(
            "Please, select a product:" + "\n" + "1 - Mother board" + "\n" + "2 - CPU" + "\n"
                + "3 - HDD" + "\n" + "4 - Memory" + "\n");
        int choice = Integer.parseInt(reader.readLine());
        cost = priceOnProducts.get(choice);
        System.out.println("Count: ");
        int count = Integer.parseInt(reader.readLine());
        order.setTotalCost(cost * count);
        System.out.println("Do you wish to continue selecting products? Y/N: ");
        continueChoice = reader.readLine();
      } while (continueChoice.equalsIgnoreCase("Y"));

      if (strategy == null) {
        System.out.println(
            "Please, select a payment method:" + "\n" + "1 - PalPay" + "\n" + "2 - Credit Card");
        String paymentMethod = reader.readLine();

        // Clients creates different strategies based on input from user,
        // application configuration, etc.
        if (paymentMethod.equals("1")) {
          strategy = new PayByPayPal();
        } else {
          strategy = new PayByCreditCard();
        }
      }

      // Order object delegates gathering payment data to strategy object,
      // since only strategies know what data they need to process a payment.
      order.processOrder(strategy);

      System.out.println("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
      String proceed = reader.readLine();
      if (proceed.equalsIgnoreCase("P")) {
        // Finally, strategy handles the payment.
        if (strategy.pay(order.getTotalCost())) {
          System.out.println("Payment has been successful.");
        } else {
          System.out.println("Fail! please, check your data.");
        }
        order.setClosed();
      }
    }
  }
}
