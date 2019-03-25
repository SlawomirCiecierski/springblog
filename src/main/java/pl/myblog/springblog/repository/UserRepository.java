package pl.myblog.springblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.myblog.springblog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  //tu będą zapisane wszelkie zapytania
  //SELECT * FROM user WHERE email = ?
  User findByEmail (String email);


  //select * from user where email =? and password = ?
  User findByEmailAndPassword(String email, String password);



}
