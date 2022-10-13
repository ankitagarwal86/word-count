package org.csgi.digital.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordsUtilTest {

    @Test
    void should_get_all_the_lines() {
        List<String> words = WordsUtil.getWordsFromString("My name is Ankit Agarwal");
        assertThat(words).hasSize(5);
        assertThat(words).containsExactly("My", "name", "is", "Ankit", "Agarwal");
    }

    @Test
    void should_return_empty_list_when_string_is_null() {
        List<String> words = WordsUtil.getWordsFromString(null);
        assertThat(words).isEmpty();
    }
}