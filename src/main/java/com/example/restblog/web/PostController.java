package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController

@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostsRepository postsRepository;

    public PostController (PostsRepository postsRepository) {

        this.postsRepository = postsRepository;

    }



    @GetMapping
    public List<Post> getAll () {
        return postsRepository.findAll();
    }


    @GetMapping("{id}")
    public Post getById(@PathVariable Long id){
    return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost);
    }

}
