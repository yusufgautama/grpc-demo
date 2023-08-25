package org.example.gateway;

import org.example.grpc.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts(Integer limit);

    Post getPostsById(Integer id);
}
