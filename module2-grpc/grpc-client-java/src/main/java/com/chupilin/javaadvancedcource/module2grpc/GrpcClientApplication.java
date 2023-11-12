package com.chupilin.javaadvancedcource.module2grpc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class GrpcClientApplication {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();
        PingPongServiceGrpc.PingPongServiceBlockingStub stub =
                PingPongServiceGrpc.newBlockingStub(channel);
        PingRequest request = PingRequest.newBuilder()
                .setMessage("ping")
                .setTimestamp(System.currentTimeMillis())
                .build();
        System.out.printf("Sending a request: [%s]%n", request);
        PongResponse response = stub.pingPong(request);
        System.out.printf("Received a response: [%s]%n", response);
        channel.shutdown();
    }

}
