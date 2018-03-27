import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ScanningText {
// Written by: Mike Baldwin
// Project 6 - Part 4 - Scanning Text
// This program reads in a line of text
// and gives as output the number of letters,
// the number of string tokens,
// and a table giving the frequency of each letter.

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String text;
    List<LetterFreq> letterFreqs = new ArrayList<>();
    int letterCount, tokenCount;

    System.out.print("Enter a single line of text:");
    text = scanner.nextLine();

    letterCount = 0;
    tokenCount = 0;

    for (char c : text.toCharArray()) {
        if (c == ' ') {
            tokenCount++;
            continue;
        }
        if (!Character.isLetter(c))
            continue;

        letterCount++;
        int index = letterFreqs.indexOf(new LetterFreq(Character.toUpperCase(c), 0));
        if (index >= 0)
            letterFreqs.get(index).freq++;
        else
            letterFreqs.add(new LetterFreq(Character.toUpperCase(c), 1));
    }
    tokenCount++; //This is to account for the last token

    letterFreqs.sort(Comparator.comparingInt(o -> o.c));

    System.out.println("The line contains " + letterCount + " letters.");
    System.out.println("The line contains " + tokenCount + " string tokens.");
    System.out.println("The frequency of letters is");
    for (LetterFreq letterFreq : letterFreqs) {
        System.out.println(Character.toUpperCase(letterFreq.c) + " -- " +
                letterFreq.freq);
    }
}
}
