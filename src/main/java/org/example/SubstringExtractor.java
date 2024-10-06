package org.example;

public class SubstringExtractor {
    public static void main(String[] args) {
        String input = "This is the text between A and b.";  // Case mismatch (A instead of a)
        String preText = "a";  // Marker in lowercase
        String postText = "b";

        // Convert both input and markers to lowercase to make search case-insensitive
        String lowerInput = input.toLowerCase();
        String lowerPreText = preText.toLowerCase();
        String lowerPostText = postText.toLowerCase();

        // Find the positions of preText ('a') and postText ('b')
        int startIndex = lowerInput.indexOf(lowerPreText);
        int endIndex = lowerInput.indexOf(lowerPostText);

        // Print the indices to debug
        System.out.println("startIndex: " + startIndex);  // Debugging
        System.out.println("endIndex: " + endIndex);      // Debugging

        // Check if both markers are found and are in the correct order
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            // Move startIndex to the right after the 'a'
            startIndex += lowerPreText.length();

            // Extract the substring between 'a' and 'b'
            String extractedText = input.substring(startIndex, endIndex).trim();
            System.out.println("Extracted text: " + extractedText);
        } else {
            System.out.println("Markers not found or invalid positions.");
        }
    }
}





