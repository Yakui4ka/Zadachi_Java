import javax.swing.*;
import java.util.Random;

public class ReverseArray {

    public static void main(String[] args) {
        try {
            // Ввод размера массива
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите длину массива (n):"));

            // Проверка корректности введенных данных
            if (n <= 0) {
                JOptionPane.showMessageDialog(null, "Длина массива должна быть положительным целым числом.");
                return;
            }

            // Создание и заполнение массива случайными целыми числами
            int[] array = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(100); // случайные числа от 0 до 99
            }

            // Обращение порядка следования элементов массива
            int[] reversedArray = new int[n];
            for (int i = 0; i < n; i++) {
                reversedArray[i] = array[n - 1 - i];
            }

            // Формирование строки с результатами для вывода
            StringBuilder result = new StringBuilder();
            result.append("Исходный массив:\n");
            for (int value : array) {
                result.append(value).append(" ");
            }
            result.append("\n\nПеревернутый массив:\n");
            for (int value : reversedArray) {
                result.append(value).append(" ");
            }

            // Вывод результата в диалоговом окне
            JOptionPane.showMessageDialog(null, result.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректное целое число.");
        }
    }
}
