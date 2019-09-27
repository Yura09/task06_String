package com.epam.string.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<Sentence> text = new ArrayList<>();

    public Text(List<Sentence> text) {
        this.text = text;
    }

    public Text(String text) {
        parseToSentence(text);
    }

    private void parseToSentence(String text) {
        Pattern p = Pattern.compile("[^.]+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String sentence = text.substring(m.start(), m.end());
            this.text.add(new Sentence(sentence));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Sentence s : text) {
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }

    public int size() {
        return text.size();
    }

    public List<Sentence> getText() {
        return text;
    }
}
