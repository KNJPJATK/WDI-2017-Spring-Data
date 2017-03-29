package pl.einstain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.einstain.entity.Post;

/**
 * Created by rpi on 26.03.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByTopicId(Pageable pageable, Long topicId);
}
