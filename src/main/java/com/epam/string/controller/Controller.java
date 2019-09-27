package com.epam.string.controller;

import com.epam.string.model.Sentence;
import com.epam.string.model.Text;
import com.epam.string.model.Word;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Controller {
    private static final String fileName = "C:\\1 курс\\task06_String\\src\\main\\resources\\Text.txt";
    Text text;

    public Controller() {
        text = new Text(fileName);
    }

    public Map<Sentence, Long> task1() {
        Map<Sentence, Long> map = new HashMap<>();
        for (Sentence sentence : text.getText()) {
            Map<Word, Long> wordCounting = sentence.getSentence().stream().collect(groupingBy((x -> x), counting()));
            long sumOfRepeatedWords = 0;
            for (Word word : wordCounting.keySet()) {
                if (wordCounting.get(word) != 1) {
                    sumOfRepeatedWords += wordCounting.get(word);
                }
            }
            map.put(sentence, sumOfRepeatedWords);
        }
        /*for (Sentence sentence : map.keySet()) {
            System.out.println(sentence + "  " + map.get(sentence));
        }*/
        return map;
    }
}
