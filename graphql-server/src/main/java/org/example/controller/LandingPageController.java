package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.gateway.HeaderService;
import org.example.gateway.PostService;
import org.example.grpc.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LandingPageController {

    private final PostService postService;

    private final HeaderService headerService;

    @QueryMapping
    public List<Post> recentPosts(@Argument int limit) {
        return postService.getPosts(limit);
    }

    @QueryMapping
    public List<Post> getPost(@Argument int limit) {
        return postService.getPosts(limit);
    }
}
