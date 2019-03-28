package pl.myblog.springblog.model;

import lombok.Data;
import org.hibernate.annotations.Type;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  private String name;
  private String email;
  private String phone;
  @Type(type="text")
  private String message;



}
