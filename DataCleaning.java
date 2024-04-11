import java.util.regex.Pattern;

public class DataCleaning {

    public static String convertToLowerCase(String text) {
        String textInLowerCase = text.toLowerCase();
        return textInLowerCase;
    }

    public static String removeContractionWord(String textInLowerCase) {
        String[] contractions = {"can't", "you're", "it's"};
        String contractionFreeText = textInLowerCase;

        for (String contraction : contractions) {
            contractionFreeText = contractionFreeText.replaceAll("\\b" + Pattern.quote(contraction) + "\\b", "");
        }

        return contractionFreeText;
    }


    public static String removeEmoticons(String contractFreeText) {
        String[] emoticons = {":)", ":d", ":o", "o_o", "xd"};
        String emoticonsFreeText = contractFreeText;
        for (String emoticon : emoticons) {
            emoticonsFreeText = emoticonsFreeText.replaceAll(Pattern.quote(emoticon), "");
        }
        return emoticonsFreeText;
    }

    public static String removePunctuations(String emoticonsFreeText) {
        String puncRemovedText = "";

        for (int i = 0; i < emoticonsFreeText.length(); i++) {
            char ch = emoticonsFreeText.charAt(i);
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)) {
                puncRemovedText += ch;
            }
        }

        return puncRemovedText;
    }

    public static String removeDigit(String puncRemovedText) {
        String digitRemovedText = "";

        for (int i = 0; i < puncRemovedText.length(); i++) {
            char ch = puncRemovedText.charAt(i);
            if (!Character.isDigit(ch)) {
                digitRemovedText += ch;
            }
        }

        return digitRemovedText;
    }

    public static String cleanedTextWithRootWord(String digitRemoved) {
        String cleanedText = "";
        String[] splittedWords = digitRemoved.split("\\s+");

        for (String word : splittedWords) {
            int count = 0;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (i > 0 && word.charAt(i) == word.charAt(i - 1)) {
                    count++;
                } else {
                    if (count >= 3) {
                        word = word.substring(0, word.length() - count);
                    }
                    count = 0;
                }
            }
            cleanedText += word + " ";
        }

        return cleanedText.trim();
    }


}




