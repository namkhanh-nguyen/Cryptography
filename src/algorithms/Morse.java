package algorithms;

import java.util.HashMap;
import java.util.Scanner;

public class Morse {

    // HashMap for storing Morse code mappings
    private static final HashMap<Character, String> morseEncodeMap = new HashMap<>();
    private static final HashMap<String, Character> morseDecodeMap = new HashMap<>();

    // Initializing the Morse code map
    static {
    	
    	//Latin alphabet
        morseEncodeMap.put('A', ".-");
        morseEncodeMap.put('B', "-...");
        morseEncodeMap.put('C', "-.-.");
        morseEncodeMap.put('D', "-..");
        morseEncodeMap.put('E', ".");
        morseEncodeMap.put('F', "..-.");
        morseEncodeMap.put('G', "--.");
        morseEncodeMap.put('H', "....");
        morseEncodeMap.put('I', "..");
        morseEncodeMap.put('J', ".---");
        morseEncodeMap.put('K', "-.-");
        morseEncodeMap.put('L', ".-..");
        morseEncodeMap.put('M', "--");
        morseEncodeMap.put('N', "-.");
        morseEncodeMap.put('O', "---");
        morseEncodeMap.put('P', ".--.");
        morseEncodeMap.put('Q', "--.-");
        morseEncodeMap.put('R', ".-.");
        morseEncodeMap.put('S', "...");
        morseEncodeMap.put('T', "-");
        morseEncodeMap.put('U', "..-");
        morseEncodeMap.put('V', "...-");
        morseEncodeMap.put('W', ".--");
        morseEncodeMap.put('X', "-..-");
        morseEncodeMap.put('Y', "-.--");
        morseEncodeMap.put('Z', "--..");
        
        //German alphabet
        morseEncodeMap.put('Ä', ".-.-");
        morseEncodeMap.put('Ö', "---.");
        morseEncodeMap.put('Ü', "..--");

        // Numbers
        morseEncodeMap.put('1', ".----");
        morseEncodeMap.put('2', "..---");
        morseEncodeMap.put('3', "...--");
        morseEncodeMap.put('4', "....-");
        morseEncodeMap.put('5', ".....");
        morseEncodeMap.put('6', "-....");
        morseEncodeMap.put('7', "--...");
        morseEncodeMap.put('8', "---..");
        morseEncodeMap.put('9', "----.");
        morseEncodeMap.put('0', "-----");

        // Special chars
        morseEncodeMap.put('.', ".-.-.-");
        morseEncodeMap.put(',', "--..--");
        morseEncodeMap.put('?', "..--..");
        morseEncodeMap.put('\'', ".----.");
        morseEncodeMap.put('!', "-.-.--");
        morseEncodeMap.put('/', "-..-.");
        morseEncodeMap.put('(', "-.--.");
        morseEncodeMap.put(')', "-.--.-");
        morseEncodeMap.put('&', ".-...");
        morseEncodeMap.put(':', "---...");
        morseEncodeMap.put(';', "-.-.-.");
        morseEncodeMap.put('=', "-...-");
        morseEncodeMap.put('+', ".-.-.");
        morseEncodeMap.put('-', "-....-");
        morseEncodeMap.put('_', "..--.-");
        morseEncodeMap.put('"', ".-..-.");
        morseEncodeMap.put('$', "...-..-");
        morseEncodeMap.put('@', ".--.-.");

        // Creating reverse map for decoding
        for (HashMap.Entry<Character, String> entry : morseEncodeMap.entrySet()) 
            morseDecodeMap.put(entry.getValue(), entry.getKey());        
    }

    // Method to encode text to Morse code
    public static String encodeToMorse(String text) {
        if(text == null || text.isEmpty())
            throw new NullPointerException("text is null");

        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) 
            if (morseEncodeMap.containsKey(c)) 
                morse.append(morseEncodeMap.get(c)).append(" ");
             else if (c == ' ') 
                morse.append("/ ");
             else if (c == '\r' || c == '\n')
            	 morse.append("/ ");
             else 
                morse.append("? ");  // Unknown character
          
        return morse.toString().trim();
    }

    // Method to decode Morse code to text
    public static String decodeFromMorse(String morse) {
        if(morse == null || morse.isEmpty())
            throw new NullPointerException("morse is null");

        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" {3}");  // Splitting words based on 3 spaces
        for (String word : words) {
            String[] characters = word.split(" ");
            for (String morseChar : characters) 
                if (morseDecodeMap.containsKey(morseChar)) 
                    text.append(morseDecodeMap.get(morseChar));
                else if(morseChar.contains("/"))
                	text.append(" ");
            text.append(' ');
        }
        return text.toString().trim();
    }

    public static void runMorseEncryption(int choice, Scanner scanner)  {
        if (choice == 1) {
            System.out.print("Enter plaintext to encode: ");
            String text = scanner.nextLine();
            String morseCode = encodeToMorse(text);
            System.out.println(morseCode);
        }
        else if (choice == 2)
        {
            System.out.print("Enter Morse to decode: ");
            String morse = scanner.nextLine();
            String decodedText = decodeFromMorse(morse);
            System.out.println("Decoded Text: " + decodedText);
        }
        else
            System.out.println("Invalid choice.");
    }

}
