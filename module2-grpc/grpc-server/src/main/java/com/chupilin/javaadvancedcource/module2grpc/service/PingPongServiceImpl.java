package com.chupilin.javaadvancedcource.module2grpc.service;

import com.chupilin.javaadvancedcource.module2grpc.PingPong;
import com.chupilin.javaadvancedcource.module2grpc.PingPongServiceGrpc;
import com.chupilin.javaadvancedcource.module2grpc.PingRequest;
import com.chupilin.javaadvancedcource.module2grpc.PongResponse;

import io.grpc.stub.StreamObserver;

public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void pingPong(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        String messageFromClient = request.getMessage();
        System.out.println("Received a message: " + messageFromClient);
        PongResponse response = PongResponse.newBuilder()
                .setMessage("pong")
                .setTimestamp(System.currentTimeMillis())
                .build();
        System.out.printf("Sending a response: [%s]", response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
