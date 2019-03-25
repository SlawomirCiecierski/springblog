package pl.myblog.springblog.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
  @Id                                             //PR
  @GeneratedValue(strategy = GenerationType.AUTO)  //AI
  private Long id;
  @NotNull                                        //NN
  private String name;
  @NotNull
  private String lastname;
  @Email                                          //email validation
  @NotNull
  private String email;
  @Length(min = 8)
  @Pattern(regexp = "([A-Z]+.*[0-9]+|[0-9]+.*[A-Z])") //conajmniej 1 litera 1 cyfra
  private String password;
  private Boolean active = true;
  private LocalDateTime registered_date = LocalDateTime.now();

  @ManyToMany
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  Set<Role> roles=new HashSet<>();


  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
  private Set<Post> posts=new HashSet<>();



}
