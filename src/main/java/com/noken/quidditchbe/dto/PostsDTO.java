package com.noken.quidditchbe.dto;

import com.noken.quidditchbe.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsDTO {

    private List<Post> posts;
    private long totalCount;
}
