package com.noken.quidditchbe.dto;

import com.noken.quidditchbe.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2929020464539242536L;

    private List<Post> posts;
    private long totalCount;

}
