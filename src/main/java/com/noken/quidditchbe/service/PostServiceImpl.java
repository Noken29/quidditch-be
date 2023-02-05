package com.noken.quidditchbe.service;

import com.noken.quidditchbe.domain.Post;
import com.noken.quidditchbe.dto.PostsDTO;
import com.noken.quidditchbe.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public PostsDTO getAll(int page, int length) {
        TypedQuery<Post> postsQuery = em.createQuery("SELECT p FROM Post p", Post.class);
        TypedQuery<Long> totalCountQuery = em.createQuery("SELECT COUNT(p) FROM Post p", Long.class);
        List<Post> posts = postsQuery
                .setFirstResult((page - 1) * length)
                .setMaxResults(length)
                .getResultList();
        Long totalCount = totalCountQuery.getSingleResult();
        return PostsDTO.builder()
                .posts(posts)
                .totalCount(totalCount)
                .build();
    }

    @Override
    public boolean deleteById(Long id) {
        postRepository.deleteById(id);
        return true;
    }
}
