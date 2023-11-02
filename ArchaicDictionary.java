import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Represents an archaic dictionary, allowing for loading and searching of word definitions using HashMaps.
 * 
 * @author Marti Lonnemann
 * @version 1.0
 * Assignment 5.1 - Archaic Dictionary
 * Fall/2023
 */
public class ArchaicDictionary {
    private HashMap<String, String> dictionary;

    /**
     * Constructs an ArchaicDictionary object and loads the dictionary from the
     * specified file.
     *
     * @param filePath The path to the dictionary file.
     */
    public ArchaicDictionary(String filePath) {
        dictionary = new HashMap<>();
        loadDictionary(filePath);
    }

    /**
     * Loads the dictionary from a file.
     *
     * @param filePath The path to the dictionary csv file.
     */
    private void loadDictionary(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length >= 2) {
                    String word = parts[0].trim();
                    String definition = parts[1].trim();
                    dictionary.put(word, definition);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }
    }

    /**
     * Gets the definition of the specified word.
     *
     * @param word The word to search for in the dictionary.
     * @return The definition of the word.
     */
    public String getDefinition(String word) {
        return dictionary.get(word);
    }

    /**
     * Returns the entire dictionary with all word-definition pairs.
     *
     * @return A HashMap containing all the word-definition pairs in the dictionary.
     */
    public HashMap<String, String> getAllWords() {
        return dictionary;
    }
}
