import algorithms.Morse;
import algorithms.Vigenere;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("General Cryptography");
        System.out.println("Choose an algorithm: ");
        System.out.println("1: Morse code");
        System.out.println("2: Vigenere");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Do you want to encode or decode?");
        System.out.println("1: Encode a message");
        System.out.println("2: Decode a message");

        int nextChoice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1)
            Morse.runMorseEncryption(nextChoice, scanner);
        else if (choice == 2)
            Vigenere.runVigenereCipher(nextChoice, scanner);
        else
            System.out.println("Invalid choice");

        scanner.close();
    }

}
