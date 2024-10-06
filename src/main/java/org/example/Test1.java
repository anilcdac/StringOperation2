package org.example;

public class Test1 {

        // Method to extract text after the preText in inputText
        public static String extractText(String inputText, String preText) {
            // Convert both inputText and preText to lowercase for case-insensitive search
            String lowerInputText = inputText.toLowerCase();
            String lowerPreText = preText.toLowerCase();

            // Find the position of the preText in the inputText
            int startIndex = lowerInputText.indexOf(lowerPreText);

            if (startIndex == -1) {
                // PreText not found in the input text
                return "PreText not found";
            }

            // Adjust the start index to the end of the preText
            startIndex += preText.length();

            // Extract the substring starting right after the preText
            String result = inputText.substring(startIndex).trim();

            // Use regular expression to extract the number or word following the preText
            String[] parts = result.split("\\s+"); // Split by spaces
            if (parts.length > 0) {
                // Return the first part after splitting (this will be the desired value)
                return parts[0];
            } else {
                return "No postText found";
            }
        }

        public static void main(String[] args) {
            // Test cases
            String inputText = "This is Application Number 12345 BEN 12      .";

            // Test case 1: Extract text after 'Application Number'
            String result1 = extractText(inputText, "Application Number");
            System.out.println("Extracted text after 'Application Number': " + result1);  // Expected output: 12345

            // Test case 2: Extract text after 'BEN'
            String result2 = extractText(inputText, "BEN");
            System.out.println("Extracted text after 'BEN': " + result2);  // Expected output: 12
        }
    }
