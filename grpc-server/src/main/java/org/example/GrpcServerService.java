package org.example;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpc.HeaderReply;
import org.example.grpc.HeaderRequest;
import org.example.grpc.HelloReply;
import org.example.grpc.HelloRequest;
import org.example.grpc.MyServiceGrpc;
import org.example.grpc.Post;
import org.example.grpc.PostReply;
import org.example.grpc.PostRequest;

@GrpcService
public class GrpcServerService extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        final HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getHeader(HeaderRequest req, StreamObserver<HeaderReply> responseObserver) {
        final HeaderReply reply = HeaderReply.newBuilder().setTitle("Title").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getPost(PostRequest req, StreamObserver<PostReply> responseObserver) {
        Post post1 = Post.newBuilder()
                .setId(1)
                .setTitle("Title 1")
                .setBody("Body 1")
                        .build();
        Post post2 = Post.newBuilder()
                .setId(2)
                .setTitle("Title 2")
                .setBody("Body 2")
                .build();
        final PostReply reply = PostReply.newBuilder().addPosts(post1).addPosts(post2).build();
        PostReply.newBuilder().addPosts(post1).addPosts(post2).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
