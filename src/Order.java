public class Order{

    private int order_number;
    private String customer_name;
    private String product_name;
    private int quantity;

    Order(int order_number, String customer_name, String product_name, int quantity){
        this.order_number = order_number;
        this.customer_name = customer_name;
        this.product_name = product_name;
        this.quantity = quantity;
    }

    public int getOrder_number() {
        return order_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString(){
       return "Номер заказа: "+getOrder_number()+"; Имя покупателя: "+getCustomer_name()+"; Название товара: "+getProduct_name()+"; Количество: "+getQuantity()+";";
    }
}
