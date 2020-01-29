package fr.kybox.server.service.impl;

import fr.kybox.server.model.Iss;
import fr.kybox.server.service.IssService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IssServiceImpl implements IssService {

    private final WebClient webClient;

    public IssServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Iss> getLocation() {
        return this.webClient.get().accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Iss.class);
    }
}
