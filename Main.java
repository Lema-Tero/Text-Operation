public class Main {
    public static void main(String[] args) {
        String uncleanedText = "OMG!!! Did you see that 2+2=4???? It's like, so totally amazingggggg!!!! Loveeee itttt!!!! Can't\n" +
                "believe it's so simple, LOL!!! :)\n" +
                "Hey @User123, check out this link: https://www.example.com/ It's like, the best website to\n" +
                "download Taylor swift songs everrrrr!!! :D :D\n" +
                "Me encanta la música de Taylor Swift, es tan increíble, ¿no crees? Y sus conciertos son OMG!!! :O\n" +
                ":O\n" +
                "I just finished listening to taylor swift - soooooo good!!! Can't wait to start the whole album!!! :) :)\n" +
                "\n" +
                "Dude, that album was EPIC!!!! I mean, explosions everywhere!!! And the beats? O_O Mind-\n" +
                "blowing!!! :O :O\n" +
                "\n" +
                "LOL, can't believe it's already 3:45 AM!!! Time flies when you're having fun, am I right? XD XD\n" +
                "XD :D";

        String textInLowerCase = DataCleaning.convertToLowerCase(uncleanedText);
        String contractionFreeText = DataCleaning.removeContractionWord(textInLowerCase);
        String emoticonsFreeText = DataCleaning.removeEmoticons(contractionFreeText);
        String punctuationFreeText = DataCleaning.removePunctuations(emoticonsFreeText);
        String digitFreeText = DataCleaning.removeDigit(punctuationFreeText);
        String textWithRootWord = DataCleaning.cleanedTextWithRootWord(digitFreeText);

        //System.out.println(textInLowerCase);
        // System.out.println(contractionFreeText);
        //System.out.println(emoticonsFreeText);
        //System.out.println(punctuationFreeText);
        // System.out.println(digitFreeText);
        //System.out.println(textWithRootWord);

        String commonWordsFreeText= TextProcessing.removeCommonWords(textWithRootWord);
        //TextProcessing.splitWords(textWithRootWord);
     // System.out.println(commonWordsFreeText);
       TextProcessing.displayWordsFrequencyRank(commonWordsFreeText);

    }

}



