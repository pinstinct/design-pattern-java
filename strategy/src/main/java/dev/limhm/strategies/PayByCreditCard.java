package dev.limhm.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit payment method.
 */
public class PayByCreditCard implements PayStrategy {
  private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
  private CreditCard card;

  /**
   * After card validation we can charge customer's credit card.
   * */
  @Override
  public boolean pay(int paymentAmount) {
    if (cardIsPresent()) {
      System.out.println("Paying " + paymentAmount + " using Credit Card.");
      card.setAmount(card.getAmount() - paymentAmount);
      return true;
    } else {
      return false;
    }
  }

  private boolean cardIsPresent() {
    return card != null;
  }

  /**
   * Collect credit card data.
   * */
  @Override
  public void collectPaymentDetails() {
    try {
      System.out.println("Enter the card number: ");
      String number = READER.readLine();
      System.out.println("Enter the card expiration date 'mm/yy': ");
      String date = READER.readLine();
      System.out.println("Enter the CCV code: ");
      String ccv = READER.readLine();
      card = new CreditCard(number, date, ccv);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
