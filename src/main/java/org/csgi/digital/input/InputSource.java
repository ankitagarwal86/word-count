package org.csgi.digital.input;

import java.io.IOException;
import java.net.URISyntaxException;

public interface InputSource {
    String input() throws IOException, URISyntaxException;
}
