import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class performs statistics on a sentence provided by the user.
 * It counts the total number of words and characters, as well as the number of occurrences
 * of individual words and characters.
 */
public class SentenceStatistics {

    /**
     * The main method that takes user input, performs statistics, and displays the results.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        Map<String, Integer> wordOccurrences = countWordOccurrences(sentence);
        Map<Character, Integer> charOccurrences = countCharOccurrences(sentence);

        System.out.println("Total number of words: " + wordOccurrences.size());
        System.out.println("Word occurrences: " + wordOccurrences);

        System.out.println("Total number of characters: " + charOccurrences.size());
        System.out.println("Character occurrences: " + charOccurrences);
    }

    /**
     * Counts the occurrences of individual words in the given sentence.
     *
     * @param sentence The input sentence.
     * @return A map containing words as keys and their occurrences as values.
     */
    private static Map<String, Integer> countWordOccurrences(String sentence) {
        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String word : words) {
            wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + 1);
        }

        return wordOccurrences;
    }

    /**
     * Counts the occurrences of individual characters in the given sentence.
     *
     * @param sentence The input sentence.
     * @return A map containing characters as keys and their occurrences as values.
     */
    private static Map<Character, Integer> countCharOccurrences(String sentence) {
        char[] chars = sentence.toCharArray();
        Map<Character, Integer> charOccurrences = new HashMap<>();

        for (char c : chars) {
            charOccurrences.put(c, charOccurrences.getOrDefault(c, 0) + 1);
        }

        return charOccurrences;
    }
}
