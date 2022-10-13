package org.csgi.digital.rule;

import static org.assertj.core.api.Assertions.assertThat;
import org.csgi.digital.rule.CharacterCountRule;
import org.csgi.digital.rule.PrefixRule;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class CharacterCountRuleTest {

    @Test
    void should_filter_the_chars_based_on_count() {
        CharacterCountRule rule = new CharacterCountRule(2, null);
        List<String> result = rule.onNext(Stream.of("An", "Ank", "Anki", "Ankit")).toList();
        assertThat(result).hasSize(3);
        assertThat(result).containsExactlyInAnyOrder("Ankit", "Ank", "Anki");
    }

    @Test
    void should_not_return_the_word_count_if_not_applicable() {
        CharacterCountRule rule = new CharacterCountRule(2, null);
        List<String> result = rule.onNext(Stream.of("An")).toList();
        assertThat(result).isEmpty();
    }

    @Test
    void should_apply_next_rule() {
        PrefixRule prefixRule = new PrefixRule("Ank", null);
        CharacterCountRule rule = new CharacterCountRule(3, prefixRule);
        List<String> result = rule.onNext(Stream.of("An", "Ank", "Anki", "Anand", "Ankita")).toList();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder("Anki", "Ankita");
    }
}