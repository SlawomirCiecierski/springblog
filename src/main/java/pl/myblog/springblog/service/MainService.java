package pl.myblog.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.myblog.springblog.model.User;
import pl.myblog.springblog.repository.UserRepository;

import java.util.List;

@Service
public class MainService {
  //Dependency injection
  UserRepository userRepository;

  @Autowired
  public MainService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();   //SELECT * FROM user;

  }

}
