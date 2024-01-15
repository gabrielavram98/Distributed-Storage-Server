package proiectdiz.Storage.Senders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class KeyRequestService {

    private final WebClient KeyRequestByIdClient;

    @Autowired
    public KeyRequestService(WebClient.Builder KeyRequestBuilder){
        this.KeyRequestByIdClient=KeyRequestBuilder.baseUrl("http://localhost:44316")
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    public String getKey(String jsonValue, String destination) {
        return KeyRequestByIdClient.post().uri(destination)
                .body(BodyInserters.fromValue(jsonValue))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }


    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> System.out.println(name + ": " + value)));
            return Mono.just(clientRequest);
        });
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            System.out.println("Response status: " + clientResponse.statusCode());
            clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> System.out.println(name + ": " + value)));
            return Mono.just(clientResponse);
        });
    }

}
