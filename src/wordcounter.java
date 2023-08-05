import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class wordcounter {
    private static final String[]
    STOP_WORDS={"the","and","is","of","in","a","an","to"};
    public static void main(String[] args){
        String inputText;
        if(args.length>0) {
            inputText=readFromFile(args[0]);
            if (args.length > 0) {
                inputText = readFromFile(args[0]);
            } else {
                inputText = readFromConsole();
            }
    
            if (inputText.isEmpty()) {
                System.out.println("No text provided.");
                return;
            }
    
            // Step 3: Split the string into an array of words using space or punctuation as delimiters.
            String[] words = inputText.split("[\\s,.?!;:\"'()-]+");
    
            // Step 4: Initialize a counter variable to keep track of the number of words.
            int wordCount = 0;
    
            // Step 7: Create a set of stop words to ignore.
            Set<String> stopWordsSet = new HashSet<>(Arrays.asList(STOP_WORDS));
    
            // Step 8: Create a map to store the frequency of each word.
            Map<String, Integer> wordFrequencyMap = new HashMap<>();
    
            // Step 5: Iterate through the array of words and increment the counter for each word encountered.
            for (String word : words) {
                word = word.toLowerCase(); // Convert to lowercase to ignore case sensitivity.
                if (!word.isEmpty()) {
                    wordCount++;
                    // Step 7: Ignore common words or stop words.
                    if (!stopWordsSet.contains(word)) {
                        // Step 8: Update word frequency in the map.
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
    
            // Step 6: Display the total count of words to the user.
            System.out.println("Total word count: " + wordCount);
    
            // Step 8: Display the number of unique words.
            System.out.println("Number of unique words: " + wordFrequencyMap.size());
    
            // Step 8: Display the frequency of each word.
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
        private static String readFromFile(String filename) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
            return content.toString();
        }
    
        private static String readFromConsole() {
            System.out.println("Enter your text (type 'done' in a new line to finish):");
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
                String line;
                while ((line = br.readLine()) != null && !line.equalsIgnoreCase("done")) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error reading input from console: " + e.getMessage());
            }
            return content.toString();
        }
    }

