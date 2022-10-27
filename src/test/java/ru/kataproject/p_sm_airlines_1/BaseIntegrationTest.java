package ru.kataproject.p_sm_airlines_1;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static ru.kataproject.p_sm_airlines_1.util.ResourceUtil.getResourceAsString;

@Transactional
@DirtiesContext
@Testcontainers
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "30s")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIntegrationTest {
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:13.2");

    @Autowired
    protected WebTestClient webTestClient;

    @DynamicPropertySource
    static void initProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.liquibase.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.liquibase.password", postgreSQLContainer::getPassword);
        registry.add("spring.liquibase.user", postgreSQLContainer::getUsername);
    }

    protected void getTest(String url, Resource expectedResponse, int httpCode) {
        webTestClient
                .get()
                .uri(url)
                .exchange()
                .expectStatus().isEqualTo(httpCode)
                .expectBody()
                .json(getResourceAsString(expectedResponse));
    }

    protected void postTest(String url, Resource expectedRequest, Resource expectedResponse, int httpCode) {
        webTestClient
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(getResourceAsString(expectedRequest)))
                .exchange()
                .expectStatus().isEqualTo(httpCode)
                .expectBody()
                .json(getResourceAsString(expectedResponse));
    }

    protected void patchTest(String url, Resource expectedRequest, Resource expectedResponse, int httpCode) {
        webTestClient
                .patch()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(getResourceAsString(expectedRequest)))
                .exchange()
                .expectStatus().isEqualTo(httpCode)
                .expectBody()
                .json(getResourceAsString(expectedResponse));
    }

    protected void deleteTest(String url, Resource expectedResponse, int httpCode) {
        webTestClient
                .delete()
                .uri(url)
                .exchange()
                .expectStatus().isEqualTo(httpCode)
                .expectBody()
                .json(getResourceAsString(expectedResponse));
    }

}