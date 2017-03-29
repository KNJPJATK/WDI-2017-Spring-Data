package pl.einstain.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.einstain.entity.Topic;
import pl.einstain.repository.TopicRepository;
import pl.einstain.service.TopicService;

import javax.transaction.Transactional;

/**
 * Created by rpi on 26.03.2017.
 */
@Service
public class TopicServiceImplementation implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Page<Topic> findTopicByForum(Pageable pageable, Long forumId) {
        return topicRepository.findAllByForumId(pageable, forumId);
    }

    public Topic findOne(Long id) {
        return topicRepository.findOne(id);
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    @Transactional
    public Topic deleteTopic(Long id) {
        Topic topic = findOne(id);
        topicRepository.delete(topic);
        return topic;
    }
}
