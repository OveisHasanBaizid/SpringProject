package com.example.springproject.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post/")
public class PostController {

    private final IPostService service;
    private final PostMapper mapper;

    public PostController(IPostService service, PostMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostDTO postDTO) {
        Post post = mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id) {
        Post post = service.getById(id);
        PostDTO postDTO = mapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<PostDTO>> getAll() {
        List<Post> posts = service.findAll();
        List<PostDTO> postDTOS = mapper.toPostDTOS(posts);
        return ResponseEntity.ok(postDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
