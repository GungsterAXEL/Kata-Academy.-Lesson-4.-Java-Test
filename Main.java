import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст:\n");
        System.out.println(textModifier());
    }

    public static String textModifier() {
        //1. Пользователь вводит текст одной строкой и нажимает “enter”.
        Scanner scanner = new Scanner(System.in);
        String inputedText = scanner.nextLine().trim();

        // 2. В тексте могут присутствовать различные специальные символы, которые надо обрабатывать согласно условиям ниже:
        //      a. Если в тексте между словами присутствует несколько пробелов подряд, надо оставить только один из них.
        //         Для реализации этого подпункта нельзя пользоваться методами replace() и replaceAll().
        StringBuilder changedText = new StringBuilder();
        boolean wasSpace = false;

        for (char c : inputedText.toCharArray()) {
            if (c == ' ') {
                if (!wasSpace) {
                    changedText.append(c);
                    wasSpace = true;
                }
            } else {
                changedText.append(c);
                wasSpace = false;
            }
        }

        return changedText.toString();
    }
}