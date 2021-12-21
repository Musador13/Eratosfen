package Eratosfen;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Этот класс реализует решето Эратосфена, а также используется для проверки чисел на простоту.
 * @author Dzhabirov Musa.
 */
public class Eratosfen {

    /**
     * Алгоритм нахождения всех простых чисел до некоторого целого числа N.
     * @param number целое число, до которого мы находим все простые числа.
     * @param start время в миллисекундах.
     */
    public static void fillSieve(long number, long start) {
        long theoreticalComplexity = (long)(number * Math.log(Math.log(number))); // Вычисление теоретической сложности
        long actualComplexity = 0;  // Переменная для вычисления фактической сложности алгоритма
        long time;  // Переменная для вычисления времени выполнения алгоритма
        boolean[] primes = new boolean[Math.toIntExact(number + 1)];  // Заводим булевый массив размера N
        Arrays.fill(primes, true);  // Заполняем сито значениям true, в дальнейшем все составные числа будут false

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    actualComplexity++;
                    primes[j] = false;
                }
            }
        }
        time = System.currentTimeMillis() - start;

        System.out.println("\nВычисление сложности алгоритма:");
        System.out.println("Теоретическая сложность алгоритма O(n ln ln n) = " + theoreticalComplexity + " операций.");
        System.out.println("Фактическая сложность алгоритма = " + actualComplexity + " операций.");
        System.out.println("Время работы алгоритма: " + time + "ms.\n");
        System.out.println("==============================================================");

        ArrayList<Integer> prime = new ArrayList<>(); // Список для хранения найденных простых чисел
        int count = 0;  // Счетчик простых чисел
        for (int a = 2; a < primes.length ; a++) {
            if (primes[a]) {
                prime.add(a);
                count++;
            }
        }


        System.out.println("\nКоличество простых чисел в промежутке от 2 до " + number + " = " + count);
        System.out.println("Список всех найденных простых чисел:");
        System.out.println(Arrays.toString(prime.toArray()));
//        System.out.println(Arrays.toString(prime.subList(0, 10000).toArray()));
    }

    /**
     * Алгоритм проверки числа на простоту.
     * @param number целое число, которое мы проверяем.
     */
    public static void isPrime(long number) {
        boolean num = number >= 2;
        if (number % 2 == 0) {
            num = number == 2;
        }
        if (number % 3 == 0) {
            num = number == 3;
        }
        for (int i = 5; (long) i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                num = false;
                break;
            }
        }
        System.out.println("==============================================================");
        System.out.println("\nПроверка числа на простоту:");
        System.out.println("Введенное число " + number + (num ? " - простое." : " - составное."));
        System.out.println("\n==============================================================");
    }
}