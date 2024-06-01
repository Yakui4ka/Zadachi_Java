import javax.swing.*;

public class CircleCalculations {

    public static void main(String[] args) {
        try {
            // Ввод радиуса
            double radius = Double.parseDouble(JOptionPane.showInputDialog("Введите радиус окружности:"));
            if (radius <= 0) {
                JOptionPane.showMessageDialog(null, "Радиус должен быть положительным числом.");
                return;
            }

            // Ввод выбора расчета
            String[] options = {"Площадь", "Длина"};
            int choice = JOptionPane.showOptionDialog(null, "Выберите, что рассчитать:",
                    "Выбор расчета", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            // Вычисления и вывод результата
            if (choice == 0) {
                // Расчет площади
                double area = calculateArea(radius);
                JOptionPane.showMessageDialog(null, "Площадь окружности: " + String.format("%.2f", area));
            } else if (choice == 1) {
                // Расчет длины окружности
                double circumference = calculateCircumference(radius);
                JOptionPane.showMessageDialog(null, "Длина окружности: " + String.format("%.2f", circumference));
            } else {
                JOptionPane.showMessageDialog(null, "Выбор не был сделан.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректное число.");
        }
    }

    // Метод для расчета площади окружности
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Метод для расчета длины окружности
    public static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }
}
