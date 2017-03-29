package pl.einstain.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.einstain.entity.Post;
import pl.einstain.repository.PostRepository;
import pl.einstain.service.PostService;

import javax.transaction.Transactional;

/**
 * Created by rpi on 26.03.2017.
 */
@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findPostByTopic(Pageable pageable, Long topicId) {
        return postRepository.findAllByTopicId(pageable, topicId);
    }

    public Post findOne(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public Post deletePost(Long id) {
        Post post = findOne(id);
        postRepository.delete(post);
        return post;
    }
}
