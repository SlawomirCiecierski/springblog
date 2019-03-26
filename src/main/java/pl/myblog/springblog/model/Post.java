package pl.myblog.springblog.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  private String title;
  @NotNull
  @Type(type = "text")                    // longtext
  private String content;
  @Enumerated
  private PostCategory category;
  private LocalDateTime date_added = LocalDateTime.now();


  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "post")
  private Set<Comment> comments = new HashSet<>();

  public Post(String title, String content, PostCategory category, User user) {
    this.title = title;
    this.content = content;
    this.category = category;
    this.user = user;
  }

  public Post() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public PostCategory getCategory() {
    return category;
  }

  public void setCategory(PostCategory category) {
    this.category = category;
  }

  public LocalDateTime getDate_added() {
    return date_added;
  }

  public void setDate_added(LocalDateTime date_added) {
    this.date_added = date_added;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }

  //  public String getUser() {
//    return "Name:" + user.getName();
//  }
}