// Эмуляция интернет-магазина написать классы покупатель, товар и заказ; создать массив покупателей, массив товаров и массив заказов;
// создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа.
// Метод должен вернуть объект заказа Если в метод передан несуществующий покупатель, товар или отрицательное количество,
// метод должен выбросить соответствующее исключение (кастомное с информативным сообщением);
// Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями.
// Обработать исключения. Массив заказов записыва в файл (1 заказ - 1 строка).
// Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{
        Customer c1 = new Customer("Itachi");
        Customer c2 = new Customer("Shisui");
        Product p1 = new Product("eggs", 100);
        Product p2 = new Product("kunai",50);
        String[] customers = {c1.getName(), c2.getName()};
        String[] products = {p1.getName(), p2.getName()};
        Order[] orders = {};
        boolean chose = false;
        int count = -1;
        while (!chose){
            System.out.println("0 - завершить работу, все остальные цифры - продолжить");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            if ( a == 0) {
                chose = true;
            }
            else{
                Order(customers,products,orders);
            }
            count += 1;
        }
        System.out.println("Итоговое количесвто совершённых покупок: "+ count);


    }

    static void Order(String[] customers, String[] products, Order[] orders) throws Exception{
        int order_number = orders.length;
        System.out.println("Введите имя покупателя");
        Scanner sc = new Scanner(System.in);
        String customer_name = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < customers.length; i++) {
            if (Objects.equals(customers[i], customer_name)) {
                flag = true;
            }
        }
        if (!flag) {
            throw new Exception("Такого покупателя не существует, проверьте правильность написания");
        }
        System.out.println("Введите название товара");
        String product_name = sc.nextLine();
        flag = false;
        for (int i = 0; i < products.length; i++) {
            if (Objects.equals(products[i], product_name)) {
                flag = true;
            }
        }
        if (!flag) {
            throw new Exception("Такого товара не существует, проверьте правильность написания");
        }
        System.out.println("Введите количество товара");
        int quantity = sc.nextInt();
        if (quantity < 0) {
            throw new Exception("Вы не можете вводить отрицательные значения");
        }
        Order order = new Order(order_number, customer_name, product_name, quantity);
        System.out.println(order.toString());
        orders = add(orders, order);
        prepareFile(order);

    }


    public static Order[] add(Order[] orders, Order order){
        Order[] new_orders = new Order[orders.length+1];
        for (int i = 0; i < orders.length; i++) {
            orders[i] = new_orders[i];
        }
        new_orders[orders.length] = order;
        return new_orders;
    }

    static void prepareFile(Order order){
        try(FileWriter fileWriter = new FileWriter("Orders.txt", true)){
            fileWriter.write(order.toString()+" ");

            fileWriter.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}