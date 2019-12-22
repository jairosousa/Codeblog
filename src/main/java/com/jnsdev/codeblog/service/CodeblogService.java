package com.jnsdev.codeblog.service;

import com.jnsdev.codeblog.model.Post;

import java.util.List;

public interface CodeblogService {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post post);
}
