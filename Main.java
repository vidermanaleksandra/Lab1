//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        System.out.print("Ввкдите Х -> ");
        int X = scanner.nextInt();
        System.out.print("Ввкдите A -> ");
        int A = scanner.nextInt();
        System.out.print("Ввкдите B -> ");
        int B = scanner.nextInt();
        System.out.print("Ввкдите C -> ");
        int C = scanner.nextInt();
        System.out.print("Ввкдите D -> ");
        int D = scanner.nextInt();

        // Инициализация счетчика
        int count = 0;

        // Проверка каждого отверстия
        if (X <= A) {
            count++;
        }
        if (X <= B) {
            count++;
        }
        if (X <= C) {
            count++;
        }
        if (X <= D) {
            count++;
        }

        // Вывод результата
        System.out.println("Результат "+count);

        scanner.close();
    }
}
