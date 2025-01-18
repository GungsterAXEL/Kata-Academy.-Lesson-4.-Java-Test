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

            if (i > 0 && i < resultText.length() - 1) {
                if (c == '-') {
                    char leftChar = resultText.charAt(i - 1);
                    char rightChar = resultText.charAt(i + 1);

                    resultText.setCharAt(i - 1, rightChar);
                    resultText.setCharAt(i, leftChar);
                    i++;
                    resultText.deleteCharAt(i);
                }
            }
        }

        // c. Обрабатываем плюс в строке возврата результата.

        // d. Узнаём сумму цифр, если таковые присутствуют.
        int sum = 0;
        int count = 0;
        for (int i = 0; i < resultText.length(); i++) {
            char c = resultText.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
                count++;
                resultText.deleteCharAt(i);
            }
        }
        if (count > 0) return resultText.toString().replaceAll("\\+", "!") + " " + sum;
        return resultText.toString().replaceAll("\\+", "!");
    }
}