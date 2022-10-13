package org.csgi.digital.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.csgi.digital.service.WordCountService;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordCountServiceTest {

    private WordCountService sut = new WordCountService();


    @Test
    void should_get_the_count_of_the_words() {
        long wordsCount = sut.findWordsGreaterThanCertainLength(List.of("abcdef", "ancdrfff", "dfded"), 5);
        assertThat(wordsCount).isEqualTo(2);
    }

    @Test
    void should_not_get_the_count_of_the_words_if_condition_is_not_satisfied() {
        long wordsCount = sut.findWordsGreaterThanCertainLength(List.of("abcd", "arfff", "dfded"), 5);
        assertThat(wordsCount).isZero();
    }

    @Test
    void should_get_the_list_of_words() {
        List<String> words = sut.findWordsWithMatchingPrefix(List.of("mbcd", "Mrfff", "dfded"), "M");
        assertThat(words).hasSize(2);
        assertThat(words).containsExactly("mbcd", "Mrfff");
    }

    @Test
    void should_not_get_the_words_if_condition_is_not_satisfied() {
        List<String> words = sut.findWordsWithMatchingPrefix(List.of("abcd", "arfff", "dfded"), "M");
        assertThat(words).isEmpty();
    }
}