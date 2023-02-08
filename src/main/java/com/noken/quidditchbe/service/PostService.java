package com.noken.quidditchbe.service;

import com.noken.quidditchbe.domain.Post;
import com.noken.quidditchbe.dto.PostsDTO;

public interface PostService {

    Post save(Post post);

    Post getById(Long id);

    PostsDTO getAll(int page, int length);

    boolean deleteById(Long id);

}
