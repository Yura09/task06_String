package com.epam.string.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private List<Word> sentence = new ArrayList<>();

    public Sentence(List<Word> sentence) {
        this.sentence = sentence;
    }

    public Sentence(String sentence) {
        parseToWords(sentence);
    }

    public List<Word> getSentence() {
        return sentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence1 = (Sentence) o;
        return sentence.equals(sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word w : sentence) {
            stringBuilder.append(w + " ");
        }
        return stringBuilder.toString();
    }

    private void parseToWords(String sentence) {
        Pattern p = Pattern.compile("[\\w]+");
        Matcher m = p.matcher(sentence);
        while (m.find()) {
            String word = sentence.substring(m.start(), m.end());
            this.sentence.add(new Word(word));
        }
    }
}
