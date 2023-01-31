package com.noken.quidditchbe.service;

import com.noken.quidditchbe.dto.PostsDTO;

public interface PostService {

    PostsDTO getAll(int page, int length);

    boolean deleteById(Long id);
}
