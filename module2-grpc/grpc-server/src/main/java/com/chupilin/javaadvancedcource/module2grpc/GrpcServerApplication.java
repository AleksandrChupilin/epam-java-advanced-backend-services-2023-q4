package com.chupilin.javaadvancedcource.module2grpc;

import com.chupilin.javaadvancedcource.module2grpc.service.PingPongServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(GrpcServerApplication.class, args);

        Server server = ServerBuilder.forPort(8080)
                .addService(new PingPongServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }

}
