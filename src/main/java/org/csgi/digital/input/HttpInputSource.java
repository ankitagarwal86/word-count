package org.csgi.digital.input;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpInputSource implements InputSource {

    private final String url;
    private HttpClient client = HttpClient.newHttpClient();

    public HttpInputSource(final String url) {
        this.url = url;
    }

    @Override
    public String input() throws URISyntaxException {
        var httpRequest = HttpRequest.newBuilder(new URI(url))
                .GET()
                .build();

        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }
}
