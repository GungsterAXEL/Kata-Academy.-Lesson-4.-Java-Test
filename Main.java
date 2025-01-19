import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст:");
        String input = textModifier();
        if (input.isEmpty()) {
            System.out.println("Вы ничего не ввели!");
        } else {
            System.out.println("Отредактированный текст:");
            System.out.println(input);
        }
    }

    public static String textModifier() {
        //1. Ввод текста.
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine().trim();

        // 2.
        // a. Удаляем лишние пробелы.
        StringBuilder resultText = new StringBuilder();
        boolean wasSpace = false;

        for (char c : inputText.toCharArray()) {
            if (c == ' ') {
                if (!wasSpace) {
                    resultText.append(c);
                    wasSpace = true;
                }
            } else {
                resultText.append(c);
                wasSpace = false;
            }
        }

        // b. Обрабатываем минус.
        for (int i = 0; i < resultText.length(); i++) {
            char c = resultText.charAt(i);
            if (c == '-') {
                if (i > 0 && i < resultText.length() - 1) {
                    char leftChar = resultText.charAt(i - 1);
                    char rightChar = resultText.charAt(i + 1);
                    resultText.setCharAt(i - 1, rightChar);
                    resultText.setCharAt(i + 1, leftChar);
                }
                resultText.deleteCharAt(i);
            }
        }

        // c. Обрабатываем плюс.
        for (int i = 0; i < resultText.length(); i++) {
            if (resultText.charAt(i) == '+') resultText.setCharAt(i, '!');
        }

        // d. Узнаём сумму цифр, если таковые присутствуют.
        int sum = 0, count = 0;
        for (int i = 0; i < resultText.length(); ) {
            char c = resultText.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
                count++;
                resultText.deleteCharAt(i);
            } else i++;
        }

        if (count > 0) resultText.append(" ").append(sum);
        scanner.close();

        return resultText.toString();
    }
}