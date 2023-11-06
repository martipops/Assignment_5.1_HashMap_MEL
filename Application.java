import java.util.Map;

/**
 * Tests the archaic dictionary class by loading and searching word definitions.
 * 
 * @author Marti Lonnemann
 * @version 1.0
 * Assignment 5.1 - Archaic Dictionary
 * Fall/2023
 */

public class Application {
    public static void main(String[] args) {
        String filePath = "DictionaryWordValuePairs.csv";
        ArchaicDictionary archaicDictionary = new ArchaicDictionary(filePath);

        // Print unsorted dictionary
        System.out.println("Unsorted Dictionary:");
        for (Map.Entry<String, String> entry : archaicDictionary.getAllWords().entrySet()) {
            System.out.println("Word: " + entry.getKey() + " - Definition: " + entry.getValue());
        }

        // Search and print details for 5 words
        String[] wordsToSearch = {"cicisbeo", "gyve", "pest", "larcener", "orts"};
        for (String word : wordsToSearch) {
            String definition = archaicDictionary.getDefinition(word);
            if (definition != null) {
                int hashKey = word.hashCode();
                System.out.println("\nWord: " + word);
                System.out.println("Definition: " + definition);
                System.out.println("Hash Key: " + hashKey);
            } else {
                System.out.println("\nWord '" + word + "' not found in dictionary.");
            }
        }
    }
}
