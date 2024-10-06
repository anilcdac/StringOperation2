package org.example;

import java.util.Scanner;

public class WordAfterPretextV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the sentence (multi-line support)
        System.out.println("Enter the sentence (end with an empty line): ");
        StringBuilder sentenceBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            sentenceBuilder.append(line).append(" ");
        }
        String sentence = sentenceBuilder.toString().trim();

        // Input the pretext (it can be multiple words)
        System.out.println("Enter the pretext (multiple words are allowed): ");
        String pretext = scanner.nextLine().trim();

        // Find and display the word after the pretext
        String result = findWordAfterPretext(sentence, pretext);
        if (result != null) {
            System.out.println("The word/phrase after the pretext '" + pretext + "' is: " + result);
        } else {
            System.out.println("The pretext '" + pretext + "' was not found or there is no word after it.");
        }

        scanner.close();
    }
    public static String findWordAfterPretext(String sentence, String pretext) {
        // Find the starting index of the pretext in the sentence
        int pretextIndex = sentence.indexOf(pretext);
        if (pretextIndex == -1) {
            return null;  // Pretext not found
        }

        // Calculate where the pretext ends
        int pretextEndIndex = pretextIndex + pretext.length();

        // Extract the part of the sentence after the pretext
        String afterPretext = sentence.substring(pretextEndIndex).trim();

        // Split the remaining sentence into words and return the first word
        String[] wordsAfterPretext = afterPretext.split("\\s+");
        if (wordsAfterPretext.length > 0 && !wordsAfterPretext[0].isEmpty()) {
            return wordsAfterPretext[0];  // Return the first word/phrase after the pretext
        } else {
            return null;  // No word found after the pretext
        }
    }
}
