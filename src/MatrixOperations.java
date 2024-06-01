import javax.swing.*;
import java.util.Random;
public class MatrixOperations {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите количество строк (n):"));
            int m = Integer.parseInt(JOptionPane.showInputDialog("Введите количество столбцов (m):"));
            if (n <= 0 || m <= 0) {
                JOptionPane.showMessageDialog(null, "Размеры матрицы должны быть положительными целыми числами.");
                return;
            }
            int[][] matrix = new int[n][m];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = rand.nextInt(100); // случайные числа от 0 до 99
                }
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int[] row : matrix) {
                for (int value : row) {
                    if (value > max) {
                        max = value;
                    }
                    if (value < min) {
                        min = value;
                    }
                }
            }
            int[] rowSums = new int[n];
            int[] colSums = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rowSums[i] += matrix[i][j];
                    colSums[j] += matrix[i][j];
                }
            }
            StringBuilder result = new StringBuilder();
            result.append("Исходная матрица:\n");
            for (int[] row : matrix) {
                for (int value : row) {
                    result.append(String.format("%4d", value));
                }
                result.append("\n");
            }
            result.append("\nМаксимальное значение: ").append(max);
            result.append("\nМинимальное значение: ").append(min);
            result.append("\n\nСуммы элементов для каждой строки:\n");
            for (int i = 0; i < n; i++) {
                result.append("Строка ").append(i + 1).append(": ").append(rowSums[i]).append("\n");
            }
            result.append("\nСуммы элементов для каждого столбца:\n");
            for (int j = 0; j < m; j++) {
                result.append("Столбец ").append(j + 1).append(": ").append(colSums[j]).append("\n");
            }
            JOptionPane.showMessageDialog(null, result.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные целые числа.");
        }
    }
}
