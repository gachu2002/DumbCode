package readability;

class Text {
    private static final String wordSpacingPattern = "\\s+";
    private static final String sentenceSpacingPattern = "[?.!]";
    private static final String characterReplacePattern = "[\\s\\n\\t]";
    private static final String syllablePattern = "[aeiouy]+";

    private static final String polysyllablePattern = ".*[aeiouyAEIOUY]+[^aeiouyAEIOUY]+[aeiouyAEIOUY]+[^aeiouyAEIOUY]+[aeiouyAEIOUY]+.*]";
    private final String paragraph;
    private final int words;
    private final int sentences;
    private final int characters;
    private final int syllables;
    private final int polysyllables;

    public Text(String text) {
        this.paragraph = text;
        this.words = text.split(wordSpacingPattern).length;
        this.sentences = text.split(sentenceSpacingPattern).length;
        this.characters = text.replaceAll(characterReplacePattern, "").length();
        this.syllables = this.countSyllables();
        this.polysyllables = this.countPolysyllables();
    }

    public String getParagraph() {
        return paragraph;
    }

    public int getWords() {
        return words;
    }

    public int getSentences() {
        return sentences;
    }

    public int getCharacters() {
        return characters;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }

    public int countSyllables() {
        int count = 0;
        for (String word : paragraph.split(wordSpacingPattern)) {
            if (word.endsWith("e")) {
                word = word.substring(0, word.length() - 1);
            }
            word = word.toLowerCase().replaceAll(syllablePattern, " ");
            for (char temp : word.toCharArray()) {
                if (temp == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public int countPolysyllables() {
        int count = 0;
        for (String word : paragraph.split(wordSpacingPattern)) {
            if (word.endsWith("e")) {
                word = word.substring(0, word.length() - 1);
            }
            word = word.toLowerCase().replaceAll(syllablePattern, " ");
            int wordSyllables = 0;
            for (char temp : word.toCharArray()) {
                if (temp == ' ') {
                    wordSyllables++;
                }
            }
            count += wordSyllables > 2 ? 1 : 0;
        }
        return count;
    }

    @Override
    public String toString() {
        return paragraph + "\n\n" +
                "Words: " + words + '\n' +
                "Sentences: " + sentences + '\n' +
                "Characters: " + characters + '\n' +
                "Syllables: " + syllables + '\n' +
                "Polysyllables: " + polysyllables;
    }
}
