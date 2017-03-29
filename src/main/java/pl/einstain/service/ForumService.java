package pl.einstain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.einstain.entity.Forum;

/**
 * Created by rpi on 26.03.2017.
 */
public interface ForumService {

    Page<Forum> findAll(Pageable pageable);

    Forum saveForum(Forum forum);

    Forum deleteForum(Long id);

}
