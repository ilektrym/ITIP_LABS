import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();
        hashTable.put(1, "1");
        hashTable.put(2, "2");
        hashTable.put(2, "3");

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(2));

        hashTable.remove(1);
        System.out.println(hashTable.get(1));

        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());

        System.out.println("");

        ArrayList<String> products = new ArrayList();
        products.add("product1");
        products.add("product2");
        products.add("product3");
        Order order = new Order(products,"deliveryAddress",100000000);
        HashTable<Integer, Order> hashTable2 = new HashTable<>();
        hashTable2.put(1, order);
        hashTable2.put(2, order);
        System.out.println(hashTable2.get(1));
        System.out.println(hashTable2.get(2));
        System.out.println(hashTable2.size());
        hashTable2.remove(2);
        System.out.println(hashTable2.get(1));
        System.out.println(hashTable2.get(2));
        System.out.println(hashTable2.size());
        System.out.println(hashTable2.isEmpty());
        hashTable2.put(2, order);
        hashTable2.printHashTable();

    }
}
