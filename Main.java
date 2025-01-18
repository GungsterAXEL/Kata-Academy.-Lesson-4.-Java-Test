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
        String inputedText = scanner.nextLine().trim();

        // 2.
        // a. Удаляем лишние пробелы.
        StringBuilder spaceClearedText = new StringBuilder();
        boolean wasSpace = false;

        for (char c : inputedText.toCharArray()) {
            if (c == ' ') {
                if (!wasSpace) {
                    spaceClearedText.append(c);
                    wasSpace = true;
                }
            } else {
                spaceClearedText.append(c);
                wasSpace = false;
            }
        }

        //      b. Обрабатываем минус.
        for (int i = 0; i < spaceClearedText.length(); i++) {
            char c = spaceClearedText.charAt(i);

            if (i > 0 && i < spaceClearedText.length() - 1) {
                if (c == '-') {
                    char leftChar = spaceClearedText.charAt(i - 1);
                    char rightChar = spaceClearedText.charAt(i + 1);

                    spaceClearedText.setCharAt(i - 1, rightChar);
                    spaceClearedText.setCharAt(i, leftChar);
                    i++;
                    spaceClearedText.deleteCharAt(i);
                }
            }
        }
        return spaceClearedText.toString().replaceAll("-",""); // Возвращаем результат.
    }
}