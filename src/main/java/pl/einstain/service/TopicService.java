package pl.einstain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.einstain.entity.Topic;

/**
 * Created by rpi on 26.03.2017.
 */
public interface TopicService {

    Page<Topic> findTopicByForum(Pageable pageable, Long forumId);

    Topic saveTopic(Topic topic);

    Topic deleteTopic(Long id);
}
