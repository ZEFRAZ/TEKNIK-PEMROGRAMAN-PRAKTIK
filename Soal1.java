import java.util.Scanner;
import java.util.function.Consumer;

public class Soal1 {
    static boolean canFit(String input, Consumer<String> parser) {
        try {
            parser.accept(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of test cases: ");
        int numOfTestCases = sc.nextInt();
        sc.nextLine();

        System.out.println();
        String[] inputs = new String[numOfTestCases];
        for (int i = 0; i < numOfTestCases; i++) {
            System.out.print("Masukkan angka ke-" + (i + 1) + ": ");
            String input = sc.nextLine();
            inputs[i] = input;
        }

        System.out.println();
        for (String input : inputs) {
            if (!canFit(input, Byte::parseByte) &&
                    !canFit(input, Short::parseShort) &&
                    !canFit(input, Integer::parseInt) &&
                    !canFit(input, Long::parseLong)) {
                System.out.println(input + " can't be fitted anywhere.\n");
            } else {
                System.out.println(input + " can be fitted in:");
                if (canFit(input, Byte::parseByte)) {
                    System.out.println("* byte");
                }
                if (canFit(input, Short::parseShort)) {
                    System.out.println("* short");
                }
                if (canFit(input, Integer::parseInt)) {
                    System.out.println("* int");
                }
                if (canFit(input, Long::parseLong)) {
                    System.out.println("* long");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}