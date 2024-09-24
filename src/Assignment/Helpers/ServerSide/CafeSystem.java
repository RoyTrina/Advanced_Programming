package Assignment.Helpers.ServerSide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//This is the Bank file
public class CafeSystem {

    private final HashMap<Integer, String> ordersMap = new HashMap<>();

    public void createOrder(int orderID, String order) {
        ordersMap.put(orderID, order);
    }

    public String getOrder(int orderID) {

        return String.valueOf(ordersMap.get(orderID));
    }

    public List<String> getAllAccounts() {
        List<String> accountList = new ArrayList<>();

        for (int counter = 0; counter <= ordersMap.size(); counter++) {
            accountList.add(getOrder(counter));
        }
        return accountList;
    }

    public List<String> viewAllOrders() {
        List<String> orderList = new ArrayList<>();

        for (int counter = 0; counter <= orderList.size(); counter++) {
            orderList.add(getOrder(counter));
        }
        return orderList;
    }

    public String viewOrderStatus() {
        return "";

    }


    public void transferDrinks(int customerID, String fromOrder, String toOrder, ArrayList<String> menu) {
        synchronized (ordersMap) {

        }
    }

}
