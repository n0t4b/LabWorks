package vashchenko.ad231;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;  // Кількість простих чисел
    private int generated;    // Лічильник згенерованих простих чисел

    public PrimesGenerator(int count) {
        this.count = count;
        this.generated = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int current = 2;  // Початкове значення для перевірки на простоту

            @Override
            public boolean hasNext() {
                return generated < count;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                while (!isPrime(current)) {
                    current++;
                }

                generated++;
                return current++;
            }

            // Метод для перевірки числа на простоту
            private boolean isPrime(int number) {
                if (number < 2) return false;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}

