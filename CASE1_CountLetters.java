// CountLetters.java
//
// Reads a word from the standard input and prints the number of
// occurrences of each letter in that word.
//
import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args) {
        int[] counts = new int[26]; // Array untuk menyimpan jumlah huruf A-Z
        Scanner scan = new Scanner(System.in);

        // Minta input dari user
        System.out.print("Enter a single word (letters only, please): ");
        String word = scan.nextLine().toUpperCase(); // Konversi ke huruf besar

        // Menghitung frekuensi huruf dengan Exception Handling
        for (int i = 0; i < word.length(); i++) {
            try {
                counts[word.charAt(i) - 'A']++; // Langsung mengakses array
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not a letter: " + word.charAt(i)); // Cetak pesan kesalahan
            }
        }

        // Menampilkan hasil perhitungan huruf
        System.out.println("\nLetter frequencies:");
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println((char) (i + 'A') + ": " + counts[i]);
            }
        }
        scan.close();
    }
}