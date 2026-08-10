package POJO;

import java.util.List;

public class placeOrderPayload {
    List<Order> orders;
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
