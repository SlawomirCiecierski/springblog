package pl.myblog.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.myblog.springblog.model.User;
import pl.myblog.springblog.repository.UserRepository;

import java.util.List;

@Service
public class MainService {
  //Dependency injection
  //@Autowired
  UserRepository userRepository;

  @Autowired
  public MainService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();   //SELECT * FROM user;

  }
//endpoint zwracająca użytkownika o zadanym adresie email

  public User getUserByMail(String email) {
    return userRepository.findByEmail(email);
  }

  // endpoint zwracający liczbę uzytkowników
  public Long countAllUsers() {
    return userRepository.count();
  }

  //endpoint zmieniający aktywnośc użytkownika
  public void updateUserSctivityById(Long id) {
    //select from user where id=?
    User user = userRepository.getOne(id);
    user.setActive(!user.getActive());
    //update user
    userRepository.save(user);
  }

  //endpoint zwracający wynik logowania
  public User login(String email, String password) {
    return userRepository.findByEmailAndPassword(email, password);
  }


  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

}
