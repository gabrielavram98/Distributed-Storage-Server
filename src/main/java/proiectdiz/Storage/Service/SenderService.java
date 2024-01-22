package proiectdiz.Storage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import proiectdiz.Storage.Helpers.Properties;
import reactor.core.publisher.Mono;

@Service
public class SenderService {

    private final WebClient webClient;

    @Autowired
    public SenderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Properties.getClientBaseUrl())
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

    public String sendJsonToReceiver(String jsonValue,String destination) {

        return webClient.post().uri(destination)
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