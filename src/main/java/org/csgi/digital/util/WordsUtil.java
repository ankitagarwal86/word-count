package org.csgi.digital.util;

import java.util.Arrays;
import java.util.List;

public class WordsUtil {
    public static List<String> getWordsFromString(String words) {
        if (null != words) {
            return Arrays.stream(words.split("\n\r"))
                    .toList().stream().map(i -> i.split(" "))
                    .flatMap(u -> Arrays.stream(u))
                    .map(String::trim)
                    .toList();
        }
        return List.of();
    }
}
