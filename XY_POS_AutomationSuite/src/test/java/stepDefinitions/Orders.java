package stepDefinitions;

import pageObjects.Base_PO;
import pageObjects.Orders_PO;

public class Orders extends Base_PO {
    private Orders_PO orders_po;

    public Orders (Orders_PO orders_po) {
        this.orders_po = orders_po;
    }
}
