import java.util.Arrays;

public class MatrixProcessing {
    // Пример матрицы
    private static int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    // Вспомогательный класс для обработки строки матрицы в отдельном потоке
    private static class RowProcessor extends Thread {
        private int[] row;

        public RowProcessor(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            int maxElement = Integer.MIN_VALUE;
            for (int value : row) {
                if (value > maxElement) {
                    maxElement = value;
                }
            }
            System.out.println("Максимальный элемент в строке " + Arrays.toString(row) + " равен " + maxElement);
        }
    }

    public static void main(String[] args) {
        // Создание и запуск потоков для обработки каждой строки матрицы
        for (int[] row : matrix) {
            Thread thread = new RowProcessor(row);
            thread.start();
        }

        // Ожидание завершения работы всех потоков
        for (int[] row : matrix) {
            try {
                Thread.sleep(100); // Для наглядности ожидания
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Нахождение наибольшего элемента после завершения работы всех потоков
        int maxElement = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > maxElement) {
                    maxElement = value;
                }
            }
        }
        System.out.println("Наибольший элемент в матрице равен " + maxElement);
    }
}