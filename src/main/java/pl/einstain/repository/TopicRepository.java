package pl.einstain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.einstain.entity.Topic;

/**
 * Created by rpi on 26.03.2017.
 */
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findAllByForumId(Pageable pageable, Long forumId);

}
