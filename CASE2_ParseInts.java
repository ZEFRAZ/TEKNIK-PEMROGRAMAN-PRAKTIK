// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************

import java.util.Scanner;

public class ParseInts {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        Scanner scanLine = new Scanner(scan.nextLine());

        while (scanLine.hasNext()) {
            try {
                int val = Integer.parseInt(scanLine.next()); // Ubah token menjadi integer
                sum += val; // Tambahkan ke total jika valid
            } catch (NumberFormatException e) {
                // Tangkap exception, tetapi lanjutkan ke token berikutnya
                System.out.println("Skipping non-integer input.");
            }
        }

        System.out.println("The sum of the integers on this line is " + sum);
        scanLine.close();
        scan.close();
    }
}
