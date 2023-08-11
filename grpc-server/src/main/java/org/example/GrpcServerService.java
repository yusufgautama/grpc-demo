package org.example;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpc.HelloReply;
import org.example.grpc.HelloRequest;
import org.example.grpc.MyServiceGrpc;

@GrpcService
public class GrpcServerService extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        final HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
