package com.example.springproject.post;

import com.example.springproject.common.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Post getById(Long id) {
        Optional<Post> optionalPost = repository.findById(id);
        if (optionalPost.isEmpty())
            throw new NotFoundException("Not Found");
        return optionalPost.get();
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }
}
