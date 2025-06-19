package dev.limhm.order;


import dev.limhm.strategies.PayStrategy;

/**
 * Order class. Doesn't know the concrete payment method (strategy) user has picked. It uses common
 * strategy interface to delegate collecting payment data to strategy object. It can be used to save
 * order to database.
 */
public class Order {

  private int totalCost = 0;
  private boolean isClosed = false;

  public void processOrder(PayStrategy strategy) {
    strategy.collectPaymentDetails();
    // Here we collect and store payment data from the strategy.
  }

  public int getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(int cost) {
    this.totalCost += cost;
  }

  public boolean isClosed() {
    return isClosed;
  }

  public void setClosed() {
    isClosed = true;
  }
}
