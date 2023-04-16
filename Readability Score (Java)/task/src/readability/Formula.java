package readability;

class Formula {
    protected String name;
    protected Text text;
    protected double score;

    public Text getText() {
        return text;
    }

    public double getScore() {
        return score;
    }

    public Formula(Text text) {
        this.text = text;
    }

    public int Acessment() {
        int i = 0;
        while (i < 14) {
            if (this.score <= i) {
                System.out.printf("%s: %.2f (about %d-year-olds). %n", name, score, i + 5);
                return i + 5;
            } else {
                i++;
            }
        }
        System.out.printf("%s: %.2f (about 22-year-olds). %n", name, score);
        return 22;
    }

}

class ARI extends Formula {

    ARI(Text text) {
        super(text);
        this.name = "Automated Readability Index";
        this.score = 4.71 * text.getCharacters() / text.getWords() + 0.5 * text.getWords() / text.getSentences() - 21.43;
    }
}

class FK extends Formula {
    FK(Text text) {
        super(text);
        this.name = "Flesch-Kincaid readability tests";
        this.score = 0.39 * text.getWords() / text.getSentences() + 11.8 * text.getSyllables() / text.getWords() - 15.59;
    }
}

class SMOG extends Formula {
    SMOG(Text text) {
        super(text);
        this.name = "Simple Measure of Gobbledygook";
        this.score = 1.043 * Math.sqrt(text.getPolysyllables() * 30.0 / text.getSentences()) + 3.1291;
    }
}

class CL extends Formula {
    CL(Text text) {
        super(text);
        this.name = "Coleman-Liau index";
        this.score = 5.88 * text.getCharacters() / text.getWords() - 29.6 * text.getSentences() / text.getWords() - 15.8;
    }
}
