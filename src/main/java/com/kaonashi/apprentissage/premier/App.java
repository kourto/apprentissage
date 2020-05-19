package com.kaonashi.apprentissage.premier;
import com.kaonashi.apprentissage.premier.entity.User;
import com.kaonashi.apprentissage.premier.repository.UserRepositoryImpl;
import com.kaonashi.apprentissage.premier.service.UserService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User usrTmp = new User();

        usrTmp.setUsername("NomUtilisateurEssaieService");
        usrTmp.setPassword("mdpCheap123");
        usrTmp.setLastname("NF");
        usrTmp.setFirstname("PN");
        usrTmp.setEmail("essaieService@gmail.com");

        userService.createUser(usrTmp);

        System.out.println("L'identifiant du nouvel utilisateur ajoute a la base de donnees est: " + usrTmp.getUser_id());
    }
}
