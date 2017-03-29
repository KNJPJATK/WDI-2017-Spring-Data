package pl.einstain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.einstain.entity.Forum;

/**
 * Created by rpi on 26.03.2017.
 */
public interface ForumRepository extends JpaRepository<Forum, Long> {

}
