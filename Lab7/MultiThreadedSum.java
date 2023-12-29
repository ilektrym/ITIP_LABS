public class MultiThreadedSum {
    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int result1, result2, totalResult;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                result1 += array[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length; i++) {
                result2 += array[i];
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalResult = result1 + result2;

        System.out.println("Сумма: " + totalResult);
    }
}