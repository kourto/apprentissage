package com.kaonashi.apprentissage.premier.repository;
import com.kaonashi.apprentissage.premier.DataSourceProvider;
import com.kaonashi.apprentissage.premier.entity.User;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl {
    private Connection conn = null;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    //  Petit ajout supplementaire: utilisation de getGeneratedKeys() + Statement.RETURN_GENERATED_KEYS
    public void create(User user){
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            //  EXEMPLE EN SQL:
            //  INSERT INTO "user"(username, password, lastname, firstname, email, registration_date)
            //  VALUES ('Kaonashi', crypt('qwerty123', gen_salt('bf')), 'Courteau', 'Yves', 'Yves.Courteau@uqtr.ca', '2020-05-18');

            preparedStatement = conn.prepareStatement("INSERT INTO \"user\"(username, password, lastname, firstname, email, registration_date)" +
                    "VALUES(?, crypt(?, gen_salt('bf')), ?, ?, ?, now())", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getFirstname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.executeUpdate();

            rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                user.setUser_id(rs.getInt(1));
            }

            System.out.println("L'insertion des donnees est un succes.");
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void delete(Integer id){
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            preparedStatement = conn.prepareStatement("DELETE FROM \"user\" WHERE user_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("La supression des donnees est un succes.");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void getInfoById(Integer id){
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            preparedStatement = conn.prepareStatement("SELECT * FROM \"user\" WHERE user_id = ?");
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();
            if(rs.next()){
                System.out.println("ID: " + rs.getInt("user_id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Lastname: " + rs.getString("lastname"));
                System.out.println("Firstname: " + rs.getString("firstname"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Registration date: " + rs.getDate("registration_date"));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public User getById(Integer id){
        User user = new User();

        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            preparedStatement = conn.prepareStatement("SELECT * FROM \"user\" WHERE user_id = ?");
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();
            if(rs.next()){
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLastname(rs.getString("lastname"));
                user.setFirstname(rs.getString("firstname"));
                user.setEmail(rs.getString("email"));
                user.setRegistration_date(rs.getDate("registration_date"));
            }
            System.out.println("Le nouvel utilisateur a bien ete ajoute.");
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return user;
    }

    public List<User> list(){
        List<User> liste_user = new ArrayList<User>();

        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            preparedStatement = conn.prepareStatement("SELECT * FROM \"user\"");
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLastname(rs.getString("lastname"));
                user.setFirstname(rs.getString("firstname"));
                user.setEmail(rs.getString("email"));
                user.setRegistration_date(rs.getDate("registration_date"));
                liste_user.add(user);
            }

            System.out.println("La liste d'utilisateur a bien ete ajoute.");

        }catch(SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }return liste_user;
    }

    public void selectAll(){
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            preparedStatement = conn.prepareStatement("select * from \"user\"");
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("user_id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Lastname: " + rs.getString("lastname"));
                System.out.println("Firstname: " + rs.getString("firstname"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Registration date: " + rs.getDate("registration_date") + "\n");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    //  Return true si le password est correct.
    public boolean verifyPassword(String password_input, Integer id){
        boolean pwd = false;
        try{
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            conn = dataSource.getConnection();

            //  SQL QUERY :
            //SELECT password = crypt('qwerty123', password) FROM "user" where user_id= 1;
            preparedStatement = conn.prepareStatement("SELECT password = crypt(?, password) as pwdVerif FROM \"user\" WHERE user_id = ?");
            preparedStatement.setString(1, password_input);
            preparedStatement.setInt(2, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                pwd = rs.getBoolean("pwdVerif");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return pwd;
    }
}
