package com.example.springproject.post;

import com.example.springproject.family.Family;

import java.util.List;

public interface IPostService {
    Post save(Post post);

    void delete(Long id);

    Post getById(Long id);

    List<Post> findAll();

}
