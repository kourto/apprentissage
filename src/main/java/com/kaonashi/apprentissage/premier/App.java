package com.kaonashi.apprentissage.premier;
import com.kaonashi.apprentissage.premier.entity.User;
import com.kaonashi.apprentissage.premier.service.UserService;

import java.util.List;

public class App {
    public static void main(String[] args) {

        //  Essaies des differents services creer jusqu'a present

        UserService userService = new UserService();
        User usrTmp = new User();

        usrTmp.setUsername("NomUtilisateurEssaieService");
        usrTmp.setPassword("mdpCheap123");
        usrTmp.setLastname("NF");
        usrTmp.setFirstname("PN");
        usrTmp.setEmail("essaieService@gmail.com");

        userService.createUser(usrTmp);
        System.out.println("L'identifiant du nouvel utilisateur ajoute a la base de donnees est: " + usrTmp.getUser_id());

        userService.selectAll();

        String fakePwdInput = "qwerty123";
        if (userService.verifyPassword(fakePwdInput, 1)){
            System.out.println("Le pwd est correct.");
        }else {
            System.out.println("Le pwd est incorrect");
        }

        userService.delete(7);

        User userToGet = userService.getById(1);
        System.out.println(userToGet.toString());

        userService.getInfoById(2);
        List<User> usrList = userService.list();
        for (User usr: usrList) {
            usr.toString();
        }
    }
}
