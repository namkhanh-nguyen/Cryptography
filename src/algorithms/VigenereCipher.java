package algorithms;

import java.util.Scanner;

public class VigenereCipher {

    // Method to encode plaintext using the Vigenere cipher
    public static String encode(String plaintext, String keyword) {
        StringBuilder encoded = new StringBuilder();
        plaintext = plaintext.replaceAll("\\s+","");
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            if (Character.isLetter(p)) {
                int pValue = p - 'A';
                int kValue = keyword.charAt(i % keyword.length()) - 'A';
                char encodedChar = (char) ((pValue + kValue) % 26 + 'A');
                encoded.append(encodedChar);
            }
        }
        return encoded.toString();
    }

    // Method to decode ciphertext using the Vigenere cipher
    public static String decode(String ciphertext, String keyword) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                int cValue = c - 'A';
                int kValue = keyword.charAt(i % keyword.length()) - 'A';
                char decodedChar = (char) ((cValue - kValue + 26) % 26 + 'A');
                decoded.append(decodedChar);
            }
        }
        return decoded.toString();
    }

    // Format cipher text in blocks of 5 characters
    public static String formatCiphertext(String ciphertext) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            if (i > 0 && i % 5 == 0) {
                formatted.append(" ");
            }
            formatted.append(ciphertext.charAt(i));
        }
        return formatted.toString();
    }

    public static void runVigenereCipher(int choice, String keyword, Scanner scanner) {
        if (choice == 1) {
            System.out.print("Enter plaintext: ");
            String plaintext = scanner.nextLine().toUpperCase();
            String ciphertext = encode(plaintext, keyword);
            System.out.println("Encoded text: " + formatCiphertext(ciphertext));
        }
        else if (choice == 2) {
            System.out.print("Enter ciphertext: ");
            String ciphertext = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");
            String decodedText = decode(ciphertext, keyword);
            System.out.println("Decoded text: " + decodedText);
        } else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }
    }
}