package pl.myblog.springblog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  private String message;
  @NotNull
  private String author;

  @ManyToOne
  @JoinColumn(name="post_id")
  private Post post;

}
