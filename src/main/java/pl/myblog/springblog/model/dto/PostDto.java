package pl.myblog.springblog.model.dto;

import lombok.Data;
import org.hibernate.annotations.Type;
import pl.myblog.springblog.model.PostCategory;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;


@Data
public class PostDto {

  @NotBlank(message = "Title is required")
  private String title;
  @NotBlank(message="Content is required")
  @Type(type = "text")                    // longtext
  private String content;
  @Enumerated
  private PostCategory category;


}
