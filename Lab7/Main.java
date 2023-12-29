public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread loader1 = new Thread(() -> {
            warehouse.moveProducts(80);
            warehouse.moveProducts(50);
        });

        Thread loader2 = new Thread(() -> {
            warehouse.moveProducts(70);
            warehouse.moveProducts(40);
        });

        Thread unloader = new Thread(() -> {
            warehouse.unloadProducts(130);
            warehouse.unloadProducts(20);
        });

        loader1.start();
        loader2.start();
        unloader.start();   
    }
}