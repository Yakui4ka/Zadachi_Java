import javax.swing.*;
import java.util.Random;

public class ArrayStatistics {

    public static void main(String[] args) {
        try {
            // Ввод размера массива
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите длину массива (n):"));
            if (n <= 0) {
                JOptionPane.showMessageDialog(null, "Длина массива должна быть положительным целым числом.");
                return;
            }

            // Ввод диапазона значений
            double x = Double.parseDouble(JOptionPane.showInputDialog("Введите нижнюю границу диапазона (x):"));
            double y = Double.parseDouble(JOptionPane.showInputDialog("Введите верхнюю границу диапазона (y):"));
            if (x >= y) {
                JOptionPane.showMessageDialog(null, "Нижняя граница диапазона должна быть меньше верхней границы.");
                return;
            }

            // Создание и заполнение массива случайными вещественными числами
            double[] array = new double[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                array[i] = x + (y - x) * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
            }

            // Вычисление суммы элементов массива
            double sum = 0;
            for (double value : array) {
                sum += value;
            }

            // Вычисление среднего арифметического значения массива
            double average = sum / n;

            // Формирование строки с результатами для вывода
            StringBuilder result = new StringBuilder();
            result.append("Массив:\n");
            for (double value : array) {
                result.append(String.format("%.2f", value)).append(" ");
            }
            result.append("\n\nСумма элементов: ").append(String.format("%.2f", sum));
            result.append("\nСреднее арифметическое: ").append(String.format("%.2f", average));

            // Вывод результата в диалоговом окне
            JOptionPane.showMessageDialog(null, result.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа.");
        }
    }
}
