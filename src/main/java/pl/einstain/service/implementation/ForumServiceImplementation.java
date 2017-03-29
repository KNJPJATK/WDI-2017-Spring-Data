package pl.einstain.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.einstain.entity.Forum;
import pl.einstain.repository.ForumRepository;
import pl.einstain.service.ForumService;

import javax.transaction.Transactional;

/**
 * Created by rpi on 26.03.2017.
 */
@Service
public class ForumServiceImplementation implements ForumService {

    @Autowired
    private ForumRepository forumRepository;

    @Override
    public Page<Forum> findAll(Pageable pageable) {
        return forumRepository.findAll(pageable);
    }

    public Forum findOne(Long id) {
        return forumRepository.findOne(id);
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    @Transactional
    public Forum deleteForum(Long id) {
        Forum forum = findOne(id);
        forumRepository.delete(forum);
        return forum;
    }

}
