package com.kaonashi.apprentissage.premier;
import com.kaonashi.apprentissage.premier.entity.User;
import com.kaonashi.apprentissage.premier.repository.UserRepositoryImpl;
import java.util.List;

public class App {
    public static void main(String[] args){
        UserRepositoryImpl userRepo = new UserRepositoryImpl();

        List<User> list_user;
        list_user = userRepo.list();
        for(int i = 0; i< list_user.size(); i++) {
            System.out.println(list_user.get(i).toString());
        }

        System.out.println();
        userRepo.selectAll();

        System.out.println("\nTentative de verification de mot de passe: \n");
        String password_user_input = "qwerty123";
        boolean isCorrectPWD = userRepo.verifyPassword(password_user_input, 1);

        if(isCorrectPWD){
            System.out.println("Le password est correct.");
        }else{
            System.out.println("Le password est incorrect.");
        }
    }
}
