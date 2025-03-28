import java.util.Scanner;

public class Soal5_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca input
        System.out.println("Masukkan kata A: "); String A = scanner.nextLine();
        System.out.println("Masukkan kata B: "); String B = scanner.nextLine();

        // Menjumlahkan panjang string A dan B
        int totalLength = A.length() + B.length();
        System.out.println("Panjang kedua kata : " + totalLength);

        // Menentukan apakah A lebih besar secara leksikografis dari B
        if (A.compareTo(B) > 0) {
            System.out.println("Kata A lebih besar secara leksikografis dari kata B : Yes");
        } else {
            System.out.println("Kata A lebih besar secara leksikografis dari kata B : No");
        }

        // Mengkapitalisasi huruf pertama dari A dan B
        String capitalizedA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String capitalizedB = B.substring(0, 1).toUpperCase() + B.substring(1);

        // Menampilkan hasil
        System.out.println(capitalizedA + " " + capitalizedB);

        scanner.close();
    }
}