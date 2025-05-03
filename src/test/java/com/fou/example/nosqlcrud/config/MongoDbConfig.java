//package com.fou.example.nosqlcrud.config;
//
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.testcontainers.containers.MongoDBContainer;
//
//@Configuration
//@Profile("!mysqlTest")
//public class MongoDbConfig {
//
//
//    @ServiceConnection
//    private static final MongoDBContainer mongoDbContainer = new MongoDBContainer("momgo:7");
//
//
//    static {
//        mongoDbContainer
//                .withReuse(true)
//                .start();
//        System.setProperty("spring.data.mongodb.uri", mongoDbContainer.getConnectionString());
//        System.setProperty("spring.data.mongodb.database", "technical-content-management");
//    }
//
//}
