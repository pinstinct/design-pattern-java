package dev.limhm.strategies;

/**
 * Dummy credit card class.
 * */
public class CreditCard {

  private int amount;
  private String number;
  private String date;
  private String cvv;

  public CreditCard(String number, String date, String cvv) {
    this.number = number;
    this.date = date;
    this.cvv = cvv;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}
