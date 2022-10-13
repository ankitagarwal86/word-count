package org.csgi.digital.rule;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Ankit Agarwal
 * Business Rule based on the length of the words. for e.g if the specified wordLength is 5 than while filtering
 * it will only filter based on the above condition
 *
 */
public class CharacterCountRule implements Rule {

    private int wordLength;
    private Rule rule;

    private Predicate<String> charCountLength = (word) -> word.length() > wordLength;

    public CharacterCountRule(final int wordLength, final Rule rule) {
        this.wordLength = wordLength;
        this.rule = rule;
    }

    @Override
    public Stream<String> onNext(final Stream<String> wordStream) {
        if (null != rule) {
            return rule.onNext(wordStream.filter(charCountLength));
        }
        return wordStream.filter(charCountLength);
    }
}
