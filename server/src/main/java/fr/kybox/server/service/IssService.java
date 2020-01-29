package fr.kybox.server.service;

import fr.kybox.server.model.Iss;
import reactor.core.publisher.Mono;

public interface IssService {

    Mono<Iss> getLocation();
}
