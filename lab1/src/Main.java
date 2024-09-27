import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Введіть номер N для числа Фібоначчі (додатне число): ");
            n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Помилка! Введене число повинно бути додатним.");
            }
        } while (n < 0);

        Fibonacci fibonacci = new Fibonacci(n);

        fibonacci.displayResults();

        scanner.close();
    }
}
