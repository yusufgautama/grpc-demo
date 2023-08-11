package org.example;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.HelloReply;
import org.example.grpc.HelloRequest;
import org.example.grpc.MyServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = simpleStub.sayHello(HelloRequest.newBuilder().setName("name").build());
            return response.getMessage();
        } catch (Exception e) {
            return "FAILED with " + e.getMessage();
        }
    }

}
