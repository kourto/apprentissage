package com.kaonashi.apprentissage.premier.service;
import com.kaonashi.apprentissage.premier.entity.User;
import com.kaonashi.apprentissage.premier.repository.UserRepositoryImpl;

public class UserService {
    private UserRepositoryImpl userRepository;

    public UserService(){
        this.userRepository = new UserRepositoryImpl();
    }

    public void createUser(User user){
        userRepository.create(user);
    }

}
