package org.csgi.digital.service;

import org.csgi.digital.rule.CharacterCountRule;
import org.csgi.digital.rule.PrefixRule;

import java.util.List;

/**
 * @author Ankit Agarwal
 */
public class WordCountService {

    /**
     * This will return the count of the words based on the length of the word
     *
     * @param words  input as list of word
     * @param prefix prefix should be matched with the word prefix
     */
    public long countWordsWithMatchingPrefix(List<String> words, String prefix) {
        var prefixIgnoreCaseMatchRule = new PrefixRule(prefix, null);
        return prefixIgnoreCaseMatchRule.onNext(words.stream()).count();
    }

    /**
     * This will return the list of words based on the prefix rule
     *
     * @param words  input as list of word
     * @param length length of characters longer than specified value
     */
    public List<String> findWordsGreaterThanCertainLength(List<String> words, int length) {
        var characterCountRule = new CharacterCountRule(length, null);
        return characterCountRule.onNext(words.stream()).toList();
    }

    /**
     * This will return the list of words based on the prefix rule as well as length rule
     *
     * @param words  input as list of word
     * @param prefix prefix should be matched with the word prefix
     * @param length length of characters longer than specified value
     */
    public List<String> findWordsGreaterThanCertainLengthAndMatchingPrefix(List<String> words, int length, String prefix) {
        var characterCountRule = new CharacterCountRule(length, null);
        var prefixIgnoreCaseMatchRule = new PrefixRule(prefix, characterCountRule);
        return prefixIgnoreCaseMatchRule.onNext(words.stream()).toList();
    }
}
