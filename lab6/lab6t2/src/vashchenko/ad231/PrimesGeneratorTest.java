package vashchenko.ad231;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        // Генеруємо перші 10 простих чисел
        PrimesGenerator primes = new PrimesGenerator(10);

        // Виводимо перші N простих чисел у прямому порядку
        System.out.println("First 10 prime numbers: ");
        List<Integer> primeList = new ArrayList<>();
        for (int prime : primes) {
            primeList.add(prime);
        }
        System.out.println(primeList);

        // Виводимо прості числа у зворотному порядку
        System.out.println("Reversed order: ");
        Collections.reverse(primeList);
        System.out.println(primeList);
    }
}
