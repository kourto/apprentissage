package com.kaonashi.apprentissage.premier.service;
import com.kaonashi.apprentissage.premier.entity.User;
import com.kaonashi.apprentissage.premier.repository.UserRepositoryImpl;

import java.util.List;

public class UserService {
    private UserRepositoryImpl userRepository;

    public UserService(){
        this.userRepository = new UserRepositoryImpl();
    }

    public void createUser(User user){
        userRepository.create(user);
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }

    public void getInfoById(Integer id){
        userRepository.getInfoById(id);
    }

    public User getById(Integer id){
        User tmpUsr = userRepository.getById(id);
        return tmpUsr;
    }

    public List<User> list(){
        List<User> list_usr_tmp = userRepository.list();
        return list_usr_tmp;
    }

    public void selectAll(){
        userRepository.selectAll();
    }

    public boolean verifyPassword(String pwd_input, Integer id){
        boolean isPwdCorrect = userRepository.verifyPassword(pwd_input, id);
        return isPwdCorrect;
    }
}
