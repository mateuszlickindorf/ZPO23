import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

    /**
     * Performs statistics on a given sentence - counts the total number of words/characters and the occurrences of
     * individual words/characters.
     */
    public class SentenceStatistics {

        private String sentence;

        /**
         * Constructor of the class.
         *
         * @param sentence Optional input sentence
         */
        public SentenceStatistics(Optional<String> sentence) {
            this.sentence = sentence.orElse(null);
        }

        /**
         * Sets the input sentence for statistics.
         *
         * @param sentence Input sentence
         */
        public void setSentence(String sentence) {
            this.sentence = sentence;
        }

        /**
         * Gets the total number of words in the input sentence.
         *
         * @return The total number of words
         */
        public int getWordCount() {
            if (sentence != null && !sentence.isEmpty()) {
                return (int) Optional.ofNullable(sentence)
                        .map(s -> s.split("\\s+").length)
                        .orElse(0);
            } else {
                return 0;
            }
        }

        /**
         * Gets the total number of characters in the input sentence.
         *
         * @return The total number of characters
         */
        public int getCharCount() {
            if (sentence != null) {
                return (int) Optional.ofNullable(sentence)
                        .map(String::length)
                        .orElse(0);
            } else {
                return 0;
            }
        }

        /**
         * Gets the occurrences of individual words in the input sentence.
         *
         * @return A map containing word occurrences
         */
        public Map<String, Integer> getWordOccurrences() {
            if (sentence != null && !sentence.isEmpty()) {
                return Optional.ofNullable(sentence)
                        .map(s -> {
                            String[] words = s.split("\\s+");
                            Map<String, Integer> wordCountMap = new HashMap<>();
                            for (String word : words) {
                                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                            }
                            return wordCountMap;
                        })
                        .orElse(new HashMap<>());
            } else {
                return new HashMap<>();
            }
        }

        /**
         * Gets the occurrences of individual characters in the input sentence.
         *
         * @return A map containing character occurrences
         */
        public Map<Character, Integer> getCharOccurrences() {
            if (sentence != null) {
                return Optional.ofNullable(sentence)
                        .map(s -> {
                            Map<Character, Integer> charCountMap = new HashMap<>();
                            for (char c : s.toCharArray()) {
                                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                            }
                            return charCountMap;
                        })
                        .orElse(new HashMap<>());
            } else {
                return new HashMap<>();
            }
        }

        /**
         * Main method for showing the capabilities of the SentenceStatistics class.
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence: ");
            String userInput = scanner.nextLine();
            SentenceStatistics stats = new SentenceStatistics(Optional.of(userInput));

            System.out.println("Word Count: " + stats.getWordCount());
            System.out.println("Character Count: " + stats.getCharCount());
            System.out.println("Word Occurrences: " + stats.getWordOccurrences());
            System.out.println("Character Occurrences: " + stats.getCharOccurrences());

            scanner.close();
        }
    }
