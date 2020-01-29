package fr.kybox.server.controller;

import fr.kybox.server.model.Iss;
import fr.kybox.server.service.IssService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class Controller {

    private final IssService issService;

    public Controller(IssService issService) {
        this.issService = issService;
    }

    @GetMapping("/now")
    public Mono<Iss> issLocation() {
        return this.issService.getLocation();
    }
}
