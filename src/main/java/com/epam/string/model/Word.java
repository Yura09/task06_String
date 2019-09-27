package com.epam.string.model;

import java.util.Objects;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {

    }

    public String getWord() {
        return this.word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }


}
