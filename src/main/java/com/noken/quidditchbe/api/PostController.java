package com.noken.quidditchbe.api;

import com.noken.quidditchbe.domain.Post;
import com.noken.quidditchbe.dto.PostsDTO;
import com.noken.quidditchbe.repository.CommentRepository;
import com.noken.quidditchbe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Post> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PostsDTO> getAll(@RequestParam("page") int page, @RequestParam("length") int length) {
        return new ResponseEntity<>(postService.getAll(page, length), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Post> create(@RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.deleteById(id), HttpStatus.OK);
    }

}
