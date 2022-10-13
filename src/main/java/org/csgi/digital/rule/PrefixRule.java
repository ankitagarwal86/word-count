package org.csgi.digital.rule;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrefixRule implements Rule {

    private String prefix;
    private Rule rule;

    private Predicate<String> matchPrefix = (val) -> val.toLowerCase().startsWith(prefix);

    public PrefixRule(final String prefix,
                      final Rule rule) {
        this.prefix = prefix.toLowerCase();
        this.rule = rule;
    }


    @Override
    public Stream<String> onNext(final Stream<String> wordStream) {
        if (null != rule) {
            return rule.onNext(wordStream.filter(matchPrefix));
        }
        return wordStream.filter(matchPrefix);
    }
}
