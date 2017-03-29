package pl.einstain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.einstain.entity.Post;

/**
 * Created by rpi on 26.03.2017.
 */
public interface PostService {

    Page<Post> findPostByTopic(Pageable pageable, Long topicId);

    Post savePost(Post post);

    Post deletePost(Long id);
}
