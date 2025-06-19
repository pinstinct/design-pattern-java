package dev.limhm.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements Paypal payment method.
 * */
public class PayByPayPal implements PayStrategy {

  private static final Map<String, String> DATA_BASE = new HashMap<>();

  static {
    DATA_BASE.put("amanda1985", "amanda@ya.com");
    DATA_BASE.put("qwerty", "john@amazon.eu");
  }

  private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
  private String email;
  private String password;
  private boolean singedIn;

  /**
   * Save customer data for future shopping attempts.
   */
  @Override
  public boolean pay(int paymentAmount) {
    if (singedIn) {
      System.out.println("Paying " + paymentAmount + " using PayPal.");
      return true;
    } else {
      return false;
    }
  }

  /**
   * Collect customer's data.
   */
  @Override
  public void collectPaymentDetails() {

    try {
      while (!singedIn) {
        System.out.println("Enter the user's email: ");
        email = READER.readLine();
        System.out.println("Enter the password: ");
        password = READER.readLine();
        if (verify()) {
          System.out.println("Data verification has been successful.");
        } else {
          System.out.println("Wrong email or password!");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean verify() {
    setSignedIn(email.equals(DATA_BASE.get(password)));
    return singedIn;
  }


  private void setSignedIn(boolean signedIn) {
    this.singedIn = signedIn;
  }

}
