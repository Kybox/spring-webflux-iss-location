package fr.kybox.server;

import fr.kybox.server.controller.Controller;
import fr.kybox.server.model.Gps;
import fr.kybox.server.model.Iss;
import fr.kybox.server.service.IssService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = Controller.class)
class ServerApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private IssService issService;

    private Iss iss;

    @BeforeEach
    void init() {

        Gps gps = new Gps("123645", "6987456");
        this.iss = new Iss("123546", "success", gps);
    }

    @Test
    void controllerTest() {

        when(this.issService.getLocation()).thenReturn(Mono.just(this.iss));

        this.webTestClient.get()
                .uri("/now")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Iss.class)
                .value(resp -> assertThat(resp).isEqualTo(this.iss));
    }
}
