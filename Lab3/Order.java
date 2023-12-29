import java.util.ArrayList;

public class Order {
        private String deliveryAddress;
        private int totalCost;
        private ArrayList<String> products = new ArrayList();

        public Order(ArrayList<String> products, String deliveryAddress, int totalCost) {
            this.deliveryAddress = deliveryAddress;
            this.products = products;
            this.totalCost = totalCost;
            
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public ArrayList<String> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<String> products) {
            this.products = products;
        }
        
        public int getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(int totalCost) {
            this.totalCost = totalCost;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "products='" + products + '\'' +
                    ", deliveryAddress='" + deliveryAddress + '\'' +
                    ", totalCost=" + totalCost +
                    '}';
        }
    }