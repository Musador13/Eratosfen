import Eratosfen.Eratosfen;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        eratosfenSieve();
    }

    /**
     * Метод считывает с консоли число N, проверяет его на простоту и просеивает все числа до N решетом Эратосфена
     */
    private static void eratosfenSieve() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите число\n");
            long n = scanner.nextLong();
            long start = System.currentTimeMillis();

            Eratosfen.isPrime(n);
            Eratosfen.fillSieve(n, start);

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
