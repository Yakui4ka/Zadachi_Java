import javax.swing.*;
import java.util.Random;

public class PairwiseArraySum {

    public static void main(String[] args) {
        try {
            // Ввод размера массивов
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите длину массивов (n):"));
            if (n <= 0) {
                JOptionPane.showMessageDialog(null, "Длина массивов должна быть положительным целым числом.");
                return;
            }

            // Ввод диапазона значений
            double x = Double.parseDouble(JOptionPane.showInputDialog("Введите нижнюю границу диапазона (x):"));
            double y = Double.parseDouble(JOptionPane.showInputDialog("Введите верхнюю границу диапазона (y):"));
            if (x >= y) {
                JOptionPane.showMessageDialog(null, "Нижняя граница диапазона должна быть меньше верхней границы.");
                return;
            }

            // Создание и заполнение массивов случайными вещественными числами
            double[] array1 = new double[n];
            double[] array2 = new double[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                array1[i] = x + (y - x) * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
                array2[i] = x + (y - x) * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
            }

            // Создание массива для хранения суммы попарных элементов
            double[] sumArray = new double[n];
            for (int i = 0; i < n; i++) {
                sumArray[i] = array1[i] + array2[i];
            }

            // Формирование строки с результатами для вывода
            StringBuilder result = new StringBuilder();
            result.append("Массив 1:\n");
            for (double value : array1) {
                result.append(String.format("%.2f", value)).append(" ");
            }
            result.append("\n\nМассив 2:\n");
            for (double value : array2) {
                result.append(String.format("%.2f", value)).append(" ");
            }
            result.append("\n\nСумма попарных элементов:\n");
            for (double value : sumArray) {
                result.append(String.format("%.2f", value)).append(" ");
            }

            // Вывод результата в диалоговом окне
            JOptionPane.showMessageDialog(null, result.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа.");
        }
    }
}
