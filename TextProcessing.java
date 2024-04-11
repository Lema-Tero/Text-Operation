 public class TextProcessing {

     public static void splitWords(String cleanedText) {

         String[] splittedWords = cleanedText.split("\\s+");

         for (String word : splittedWords) {

             System.out.println(word);
         }
     }


     public static String removeCommonWords(String cleanedText) {
         String[] words = cleanedText.split("\\s+");
         String commonWordsFreeText = "";

         for (String word : words) {
             if (word.length() > 2 && !word.equals("the")) {
                 commonWordsFreeText += word + " ";
             } else if (word.length() == 1 || word.length() == 2 || word.equals("the")) {
                 commonWordsFreeText += " " ;
             }
         }

         return commonWordsFreeText.trim();
     }

     public static void displayWordsFrequencyRank(String cleanedText) {


         String[] words = cleanedText.split("\\s+");

         int[] wordFrequency = new int[words.length];

         boolean[] visited = new boolean[words.length];

         for (int i = 0; i < words.length; i++) {
             if (!visited[i]) {
                 int count = 1;
                 for (int j = i + 1; j < words.length; j++) {
                     if (words[i].equals(words[j])) {
                         count++;
                         visited[j] = true;
                     }
                 }
                 wordFrequency[i] = count;
             }
         }

         for (int i = 0; i < words.length; i++) {
             for (int j = i + 1; j < words.length; j++) {
                 if (wordFrequency[i] < wordFrequency[j]) {
                     int tempFreq = wordFrequency[i];
                     wordFrequency[i] = wordFrequency[j];
                     wordFrequency[j] = tempFreq;

                     String tempWord = words[i];
                     words[i] = words[j];
                     words[j] = tempWord;
                 }
             }
         }


         System.out.println("The top ten frequent words as keywords are:");
         System.out.println("Words:"+ "  "+"Their frequency:");
         for (int i = 0; i < 10; i++) {
             System.out.println(words[i] + ": " +wordFrequency[i]);
         }
     }

 }









