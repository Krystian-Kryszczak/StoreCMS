package app.storecms.source.provider.tim;

import app.storecms.source.provider.Provider;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMapAdapter;

import java.util.List;
import java.util.Map;

public class TimProvider extends Provider {
    static final String url = "https://www.tim.pl/graphql";
    // -------------------------------------------------- //
    private String xApiToken;
    // -------------------------------------------------- //
    public TimProvider() {
        super("tim");
    }
    // TODO
    private void auth() {
        // TODO
    }
    private HttpHeaders xApiTokenHeader() throws NullPointerException {
        if (xApiToken==null) throw new NullPointerException("Http client has not been connected to TIM graphQL!");
        return new HttpHeaders(new MultiValueMapAdapter<>(Map.of("X-Api-Token", List.of(xApiToken))));
    }
}