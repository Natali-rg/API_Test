package util.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectt {

    public Connectt() throws SQLException{
        makeConnection();
    }
    private Connection connection;

    public Connection makeConnection()throws SQLException{
        if(connection==null){
            // new Driver();
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys","root","root");
        }
        return connection;
    }

}
