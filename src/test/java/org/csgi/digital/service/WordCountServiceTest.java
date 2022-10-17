package org.csgi.digital.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordCountServiceTest {

    private WordCountService sut = new WordCountService();

    @Test
    void should_get_the_count_of_the_words() {
        long wordsCount = sut.countWordsWithMatchingPrefix(List.of("mbcd", "Mrfff", "dfded"), "M");
        assertThat(wordsCount).isEqualTo(2);
    }

    @Test
    void should_not_get_the_count_of_the_words_if_condition_is_not_satisfied() {
        long wordsCount = sut.countWordsWithMatchingPrefix(List.of("abcd", "arfff", "dfded"), "M");
        assertThat(wordsCount).isZero();
    }

    @Test
    void should_get_the_list_of_words() {
        List<String> words = sut.findWordsGreaterThanCertainLength(List.of("abcdef", "ancdrfff", "dfded"), 5);
        assertThat(words).hasSize(2);
        assertThat(words).containsExactly("abcdef", "ancdrfff");
    }

    @Test
    void should_not_get_the_words_if_condition_is_not_satisfied() {
        List<String> words = sut.findWordsGreaterThanCertainLength(List.of("abcd", "arfff", "dfded"), 5);
        assertThat(words).isEmpty();
    }
}