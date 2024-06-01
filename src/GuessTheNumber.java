import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        try {
            // Ввод диапазона значений
            int min = Integer.parseInt(JOptionPane.showInputDialog("Введите нижнюю границу диапазона (min):"));
            int max = Integer.parseInt(JOptionPane.showInputDialog("Введите верхнюю границу диапазона (max):"));
            if (min >= max) {
                JOptionPane.showMessageDialog(null, "Нижняя граница диапазона должна быть меньше верхней границы.");
                return;
            }

            // Генерация случайного числа в заданном диапазоне
            Random rand = new Random();
            int numberToGuess = rand.nextInt(max - min + 1) + min;

            boolean guessed = false;
            while (!guessed) {
                // Ввод предположения пользователя
                String userInput = JOptionPane.showInputDialog("Угадайте число от " + min + " до " + max + " (или введите 'Сдаюсь!' для выхода):");

                if (userInput.equalsIgnoreCase("Сдаюсь!")) {
                    JOptionPane.showMessageDialog(null, "Вы сдались! Загаданное число было: " + numberToGuess);
                    break;
                }

                try {
                    int guess = Integer.parseInt(userInput);

                    if (guess < min || guess > max) {
                        JOptionPane.showMessageDialog(null, "Введите число в пределах заданного диапазона.");
                        continue;
                    }

                    // Проверка предположения пользователя
                    if (guess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Загаданное число больше.");
                    } else if (guess > numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Загаданное число меньше.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Поздравляем! Вы угадали число: " + numberToGuess);
                        guessed = true;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректное число.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числа для диапазона.");
        }
    }
}
