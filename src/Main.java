import algorithms.MorseCode;
import algorithms.VigenereCipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Generic Encryption Program");
        System.out.println("Choose an algorithm: ");
        System.out.println("1: Morse code");
        System.out.println("2: Vigenere");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Do you want to encode or decode?");
        System.out.println("1: Encode a message");
        System.out.println("2: Decode a message");

        int nextChoice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1) {
            MorseCode morse = new MorseCode();
            morse.runMorseEncryption(nextChoice, scanner);
        }
        else if (choice == 2) {
            VigenereCipher vigenere = new VigenereCipher();
            System.out.print("Enter keyword: ");
            String keyword = scanner.nextLine().toUpperCase();
            vigenere.runVigenereCipher(nextChoice, keyword, scanner);
        }
        scanner.close();
    }

}
