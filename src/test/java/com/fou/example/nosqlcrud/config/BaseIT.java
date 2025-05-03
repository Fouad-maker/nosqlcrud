package com.fou.example.nosqlcrud.config;

import com.fou.example.nosqlcrud.NosqlcrudApplication;
import com.fou.example.nosqlcrud.repository.ProductRepo;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.nio.charset.StandardCharsets;

@Testcontainers
@SpringBootTest(
        classes = {NosqlcrudApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"spring.profiles.default=it"}
)
@AutoConfigureMockMvc
public abstract class BaseIT {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public ProductRepo productRepo;

    @Container
    private static final MongoDBContainer mongoDBContainer =
            new MongoDBContainer(DockerImageName.parse("mongo:7"));

    @BeforeAll
    static void startContainer() {
        mongoDBContainer.start();
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getConnectionString());
        System.setProperty("spring.data.mongodb.database", "technical-content-management");
    }


    @BeforeEach
    void cleanDatabase() {
        mongoTemplate.getDb().drop();
    }

    @SneakyThrows
    public String readResource(final String resourceName) {
        return StreamUtils.copyToString(getClass().getResourceAsStream(resourceName), StandardCharsets.UTF_8);
    }
}
