package util.sql;

import data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatemenT {
    private Statement statement;

    public StatemenT() throws SQLException {
        makeStatemenT();
    }

    public Statement makeStatemenT() throws SQLException {
        Connectt c = null;

        c = new Connectt();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }

    public void selectUsersByEmail(String email){//HomeWork список users с одинаковым email
        String s="SELECT * FROM sys.user where email=\""+email+"\";";
        try {
            ResultSet resultSet=statement.executeQuery(s);
            while (resultSet.next()){
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUserByid(String id){//HomeWork список users по id
        String s="SELECT * FROM sys.user where id=\""+id+"\"";
        User user=null;
        try {
            ResultSet resultSet=statement.executeQuery(s);
            resultSet.next();
            user=new User(resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void updatePassword(String pass, String id){//HomeWork обновление пароля
        String s="UPDATE `sys`.`user` SET `password` = \""+pass+"\" WHERE (`id` = \""+id+"\");";
        try {
            statement.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



   /* public void selectByUserNameEmail(String username, String email) {
        String s = "SELECT * FROM sys.user where username=\"" + username + "\" and email=\"" + email + "\"";
        try {
            ResultSet resultSet=statement.executeQuery(s);//запрос с ответом где resultSet это ответ
            resultSet.next();
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void selectUsersByName(String UserName){
        String s="SELECT * FROM sys.user where username=\""+UserName+"\"";
        try {
            ResultSet resultSet=statement.executeQuery(s);
            while (resultSet.next()){
                System.out.println(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insert (String username,String email,String password){
        UUID uuid=UUID.randomUUID();
        String s="INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) " +
                "VALUES (\""+username+"\", \""+email+"\", \""+password+"\", \""+uuid.toString()+"\");";
        try {
            statement.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert (String username,String email, String password, String id){
        String s="INSERT INTO `sys`.`user` (`username`, `email`, `password`, `id`) " +
                "VALUES (\""+username+"\", \""+email+"\", \""+password+"\", \""+id+"\");";
        try {
            statement.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String id){
        String s="DELETE FROM `sys`.`user` WHERE (`id` = '"+id+"');";
        try {
            statement.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getListAllUsers(){
        String s="SELECT * FROM sys.user;";
        List<User> users=new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery(s);
            while (resultSet.next()){
                users.add(new User(resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("id")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }*/

}
