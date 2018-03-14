public class LetterFreq {
    public char c;
    public int freq;

    public LetterFreq(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }

    @Override
    public boolean equals(Object obj) {
        LetterFreq letterFreq = (LetterFreq) obj;
        return c == letterFreq.c; //We only care if the letters are the same.
    }
}
