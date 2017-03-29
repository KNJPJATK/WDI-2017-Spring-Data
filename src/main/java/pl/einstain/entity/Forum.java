package pl.einstain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rpi on 26.03.2017.
 */
@Entity
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5, unique = true, nullable = false)
    private String forumCode;

    @Column(length = 128, unique = true, nullable = false)
    private String forumName;

    @OneToMany(mappedBy = "forum")
    @JsonIgnore
    private List<Topic> topics;

    public Forum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForumCode() {
        return forumCode;
    }

    public void setForumCode(String forumCode) {
        this.forumCode = forumCode;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "id=" + id +
                ", forumCode='" + forumCode + '\'' +
                ", forumName='" + forumName + '\'' +
                ", topics=" + topics +
                '}';
    }

}
