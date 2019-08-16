package cole.driscoll.personal.repo.OrderInfo;

import java.util.Objects;

public class OrderProduct {

  private int quantity;

  private String name;

  private double total;

  public int getQuantity() {
    return quantity;
  }

  public String getName() {
    return name;
  }

  public double getTotal() {
    return total;
  }

  public OrderProduct(int quantity, String name, double total) {
    this.quantity = quantity;
    this.name = name;
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OrderProduct)) {
      return false;
    }
    OrderProduct that = (OrderProduct) o;
    return quantity == that.quantity &&
        Double.compare(that.total, total) == 0 &&
        name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantity, name, total);
  }
}
