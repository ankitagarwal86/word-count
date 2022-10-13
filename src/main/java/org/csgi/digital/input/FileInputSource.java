package org.csgi.digital.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputSource implements InputSource {

    final String filePath;

    public FileInputSource(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String input() throws IOException {
        Path fileName = Path.of(filePath);
        return Files.readString(fileName);
    }
}
