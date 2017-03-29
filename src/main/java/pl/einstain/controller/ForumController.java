package pl.einstain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.einstain.entity.Forum;
import pl.einstain.service.ForumService;

/**
 * Created by rpi on 26.03.2017.
 */
@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody  Page<Forum> findAll(Pageable pageable) {
        return forumService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Forum saveForum(@RequestBody Forum forum) {
        return forumService.saveForum(forum);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Forum updateForum(@PathVariable Long id, @RequestBody Forum forum) {
        forum.setId(id);
        return forumService.saveForum(forum);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Forum deleteForum(@PathVariable Long id) {
        return forumService.deleteForum(id);
    }

}
