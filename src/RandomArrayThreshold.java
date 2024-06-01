import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomArrayThreshold {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int x = 0;

        while (true) {
            try {
                System.out.print("Введите размер массива (n): ");
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.println("Размер массива должен быть положительным числом.");
                    continue;
                }
                System.out.print("Введите пороговое значение (x): ");
                x = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }

        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100); // Заполняем массив случайными числами от 0 до 99
        }

        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] > x) {
                indices.add(i);
            }
        }

        System.out.println("Сгенерированный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Индексы элементов, значения которых превышают порог " + x + ":");
        for (int index : indices) {
            System.out.print(index + " ");
        }
    }
}
