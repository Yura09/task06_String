package com.epam.string.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFromFile {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
