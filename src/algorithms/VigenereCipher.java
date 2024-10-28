package algorithms;

import java.util.Scanner;

public class VigenereCipher {

    // Method to encode plaintext using the Vigenere cipher
    public static String encode(String plaintext, String keyword) {
        if(plaintext == null || keyword == null || plaintext.isEmpty() || keyword.isEmpty())
            throw new NullPointerException("plaintext or keyword is null");

        StringBuilder encoded = new StringBuilder();
        // Remove all whitespaces and special characters
        String cleantext = plaintext.replaceAll("\\s+","");
        for (int i = 0; i < cleantext.length(); i++) {
            char p = cleantext.charAt(i);
            char c = keyword.charAt(i % keyword.length());
            if (Character.isLetter(p)) {
                int pValue = p - 'A';
                int kValue = c - 'A';
                char encodedChar = (char) ((pValue + kValue) % 26 + 'A');
                encoded.append(encodedChar);
            }
            else if (Character.isDigit(p))
                encoded.append(p);
        }
        return encoded.toString();
    }

    // Method to decode ciphertext using the Vigenere cipher
    public static String decode(String ciphertext, String keyword) {
        if(ciphertext == null || keyword == null || ciphertext.isEmpty() || keyword.isEmpty())
            throw new NullPointerException("ciphertext or keyword is null");

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                int cValue = c - 'A';
                int kValue = keyword.charAt(i % keyword.length()) - 'A';
                char decodedChar = (char) ((cValue - kValue + 26) % 26 + 'A');
                decoded.append(decodedChar);
            }
            else if (Character.isDigit(c))
                decoded.append(c);
        }
        return decoded.toString();
    }

    // Format cipher text in blocks of 5 characters
    public static String formatCiphertext(String ciphertext) {
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            if (i > 0 && i % 5 == 0)
                formatted.append(" ");
            formatted.append(ciphertext.charAt(i));
        }
        return formatted.toString();
    }

    public static void runVigenereCipher(int choice, Scanner scanner) {

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine().toUpperCase();

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
        }
        else
            System.out.println("Invalid option. Please choose 1 or 2.");

    }
}