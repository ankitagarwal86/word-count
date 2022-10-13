package org.csgi.digital.input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ClassPathInputSource implements InputSource {

    final String filePath;

    public ClassPathInputSource(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String input() throws IOException {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(filePath);

        return new String(ioStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}
