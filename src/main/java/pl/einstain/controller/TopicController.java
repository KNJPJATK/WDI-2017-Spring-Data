package pl.einstain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.einstain.entity.Topic;
import pl.einstain.service.TopicService;

/**
 * Created by rpi on 26.03.2017.
 */
@Controller
@RequestMapping("/forum/{forumId}/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Page<Topic> findTopicByForum(Pageable pageable, @PathVariable Long forumId) {
        return topicService.findTopicByForum(pageable, forumId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Topic saveTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Topic updadeTopic(@PathVariable Long id, @RequestBody Topic topic) {
        topic.setId(id);
        return topicService.saveTopic(topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Topic deleteTopic(@PathVariable Long id) {
        return topicService.deleteTopic(id);
    }

}
