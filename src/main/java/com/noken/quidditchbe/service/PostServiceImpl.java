package com.noken.quidditchbe.service;

import com.noken.quidditchbe.domain.Post;
import com.noken.quidditchbe.domain.exception.NotFoundException;
import com.noken.quidditchbe.dto.PostsDTO;
import com.noken.quidditchbe.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    @SneakyThrows
    public Post getById(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) {
            throw new NotFoundException("Post with id: " + id + " not found.");
        }
        return postOptional.get();
    }

    @Override
    public PostsDTO getAll(int page, int length) {
        TypedQuery<Post> postsQuery = em.createQuery("SELECT p FROM Post p ORDER BY p.posted DESC", Post.class);
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
