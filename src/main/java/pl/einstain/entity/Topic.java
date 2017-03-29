package pl.einstain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rpi on 26.03.2017.
 */
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Forum forum;

    @OneToMany(mappedBy = "topic")
    @JsonIgnore
    private List<Post> posts;

    public Topic() {
    }

    @Column(length = 256, unique = true, nullable = false)
    private String topicName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", forum=" + forum +
                ", posts=" + posts +
                ", topicName='" + topicName + '\'' +
                '}';
    }

}
