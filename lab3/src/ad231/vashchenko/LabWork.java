package ad231.vashchenko;

public class LabWork { // Клас ad231.vashchenko.LabWork

    // Метод 1: Перевіряє, чи закінчується рядок на "ed"
    public boolean endsWithEd(String input) {
        return input.endsWith("ed");
    }

    // Метод 2: Обчислює суму всіх цифр у рядку
    public int sumOfDigits(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    // Метод 3: Знаходить довжину найдовшого блоку однакових символів
    public int longestBlock(String input) {
        if (input == null || input.isEmpty()) return 0;

        int maxBlockLength = 1;
        int currentBlockLength = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentBlockLength++;
                if (currentBlockLength > maxBlockLength) {
                    maxBlockLength = currentBlockLength;
                }
            } else {
                currentBlockLength = 1;
            }
        }
        return maxBlockLength;
    }

    // Метод 4: Виводить слова з рядка
    public void printWords(String input) {
        String[] words = input.trim().split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Метод 5: З'єднує два рядки по черзі символ за символом
    public String alternateMerge(String A, String B) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(A.length(), B.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < A.length()) {
                result.append(A.charAt(i));
            }
            if (i < B.length()) {
                result.append(B.charAt(i));
            }
        }
        return result.toString();
    }
}
