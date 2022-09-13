package util.sql;

import data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void selectByUserNameEmail(String username, String email) {
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
    public User getUserByid(String id){
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
}
