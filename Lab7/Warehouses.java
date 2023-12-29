import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Storage {
    private final List<Integer> items = new ArrayList<>();
    private final int maxWeight = 150;
    private int currentWeight = 0;
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    
    public void addItem(int item) throws InterruptedException {
        lock.lock();
        try {
            while (currentWeight + item > maxWeight) {
                notFull.await();
            }
            items.add(item);
            currentWeight += item;
            System.out.println("Добавлен товар весом " + item + " кг. Текущий вес: " + currentWeight + " кг.");
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }   
    public void removeItems( int item) throws InterruptedException {
        lock.lock();
        if ((currentWeight + item >= 150)){
            try {
                while (items.isEmpty()) {
                    notEmpty.await();
                }
                
                System.out.println("Грузчики отправились на другой склад с товарами: " + items);
                
                items.clear();
                currentWeight = 0;
                
                System.out.println("Грузчики разгрузили товары на другом складе.");
                
                notFull.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Loader implements Runnable {
    private final Storage storage;
    private final int[] weights;
    private final Random random = new Random();
    int sum = 0;
    
    public Loader(Storage storage, int[] weights) {
        this.storage = storage;
        this.weights = weights;
    }
    
    @Override
    public void run() {
        try {
            for (int weight : weights) {
                Thread.sleep(random.nextInt(10));
                storage.addItem(weight);
                storage.removeItems(weight);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Warehouses {
    public static void main(String[] args) {
        Storage storage = new Storage();
        int[] weights = {50, 70, 30, 30, 60, 20};
        
        Thread loader1 = new Thread(new Loader(storage, weights));
        Thread loader2 = new Thread(new Loader(storage, weights));
        Thread loader3 = new Thread(new Loader(storage, weights));

        loader1.start();
        loader2.start();
        loader3.start();
        
        try {
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Перенос товаров завершен.");
    }
}
