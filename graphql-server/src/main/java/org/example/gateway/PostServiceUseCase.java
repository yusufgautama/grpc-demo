package org.example.gateway;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.MyServiceGrpc;
import org.example.grpc.Post;
import org.example.grpc.PostReply;
import org.example.grpc.PostRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceUseCase implements PostService {

    @GrpcClient("grpc-server")
    private MyServiceGrpc.MyServiceBlockingStub simpleStub;

    @Override
    public List<Post> getPosts(Integer limit) {
        try {
            final PostReply response =
                    simpleStub.getPost(PostRequest.newBuilder().setLimit(limit).build());
            return response.getPostsList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Post getPostsById(Integer id) {
        return null;
    }
}
