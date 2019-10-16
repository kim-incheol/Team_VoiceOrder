package application;

import javafx.beans.property.StringProperty;

public class TableRowDataModel {
    private StringProperty product_name;
    private StringProperty product_price;
    private StringProperty product_num;

    public TableRowDataModel(StringProperty product_name, StringProperty product_price, StringProperty product_num) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_num = product_num;
    }

    public StringProperty nameProperty() {
        return product_name;
    }
    public StringProperty priceProperty() {
        return product_price;
    }
    public StringProperty numProperty() {
        return product_num;
    }
}


