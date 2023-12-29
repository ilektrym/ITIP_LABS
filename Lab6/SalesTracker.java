import java.util.LinkedHashMap;
import java.util.Map;

public class SalesTracker {
    private Map<String, Integer> sales;

    public SalesTracker() {
        sales = new LinkedHashMap<>();
    }

    public void addSale(String item, int cen) {
        if (sales.containsKey(item)) {
            sales.put(item, sales.get(item) + cen);
        } else {
            sales.put(item, cen);
        }
    }

    public void printSales() {
        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getTotalSales() {
        int total = 0;
        for (int count : sales.values()) {
            total += count;
        }
        return total;
    }

    public String getMostPopularItem() {
        int maxSales = 0;
        String mostPopularItem = "";
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopularItem = entry.getKey();
            }
        }
        return mostPopularItem;
    }
}