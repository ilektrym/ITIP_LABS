import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAverange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        int sum = 0;
        try {
            for (int i = 0; i < length; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }
            double average = (double) sum / length;
            System.out.println("Среднее: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Программа выходит за пределы массива: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных: " + e.getMessage());
        }
    }
}