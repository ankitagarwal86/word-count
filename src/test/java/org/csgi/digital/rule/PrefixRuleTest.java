package org.csgi.digital.rule;

import static org.assertj.core.api.Assertions.assertThat;
import org.csgi.digital.rule.CharacterCountRule;
import org.csgi.digital.rule.PrefixRule;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class PrefixRuleTest {

    @Test
    void should_filter_the_chars_based_on_prefix() {
        PrefixRule rule = new PrefixRule("M", null);
        List<String> result = rule.onNext(Stream.of("Man", "mat", "apple")).toList();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder("Man", "mat");
    }

    @Test
    void should_not_return_the_words_if_not_applicable() {
        PrefixRule rule = new PrefixRule("M", null);
        List<String> result = rule.onNext(Stream.of("A")).toList();
        assertThat(result).isEmpty();
    }

    @Test
    void should_apply_next_rule() {
        CharacterCountRule rule = new CharacterCountRule(3, null);
        PrefixRule prefixRule = new PrefixRule("M", rule);
        List<String> result = prefixRule.onNext(Stream.of("Man", "mat", "mend", "Monkey", "java")).toList();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder("mend", "Monkey");
    }
}