package pl.einstain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.einstain.entity.Post;
import pl.einstain.service.PostService;

/**
 * Created by rpi on 26.03.2017.
 */
@Controller
@RequestMapping("/forum/{forumId}/topic/{topicId}")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page<Post> findPostByTopic(Pageable pageable, @PathVariable Long topicId) {
        return postService.findPostByTopic(pageable, topicId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postService.savePost(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Post deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
