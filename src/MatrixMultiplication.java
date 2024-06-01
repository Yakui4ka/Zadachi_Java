import javax.swing.*;
import java.util.Random;

public class MatrixMultiplication {

    public static void main(String[] args) {
        try {
            // Ввод размерности матриц
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите размерность матриц (n):"));
            if (n <= 0) {
                JOptionPane.showMessageDialog(null, "Размерность матриц должна быть положительным целым числом.");
                return;
            }

            // Ввод диапазона значений
            double x = Double.parseDouble(JOptionPane.showInputDialog("Введите нижнюю границу диапазона (x):"));
            double y = Double.parseDouble(JOptionPane.showInputDialog("Введите верхнюю границу диапазона (y):"));
            if (x >= y) {
                JOptionPane.showMessageDialog(null, "Нижняя граница диапазона должна быть меньше верхней границы.");
                return;
            }

            // Создание и заполнение матриц случайными вещественными числами
            double[][] matrix1 = new double[n][n];
            double[][] matrix2 = new double[n][n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix1[i][j] = x + (y - x) * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
                    matrix2[i][j] = x + (y - x) * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
                }
            }

            // Вычисление произведения матриц
            double[][] productMatrix = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            // Формирование строки с результатами для вывода
            StringBuilder result = new StringBuilder();
            result.append("Матрица 1:\n");
            appendMatrix(result, matrix1);
            result.append("\nМатрица 2:\n");
            appendMatrix(result, matrix2);
            result.append("\nПроизведение матриц:\n");
            appendMatrix(result, productMatrix);

            // Вывод результата в диалоговом окне
            JOptionPane.showMessageDialog(null, result.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа.");
        }
    }

    private static void appendMatrix(StringBuilder result, double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                result.append(String.format("%.2f", value)).append("\t");
            }
            result.append("\n");
        }
    }
}
