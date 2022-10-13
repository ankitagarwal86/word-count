package org.csgi.digital.input;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClassPathInputSourceTest {

    @Test
    void should_get_the_string_from_file() throws IOException {
        ClassPathInputSource classPathInputSource = new ClassPathInputSource("input.txt");
        var words = classPathInputSource.input();
        assertThat(words).isNotEmpty();
    }
}