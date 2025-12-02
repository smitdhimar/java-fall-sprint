package jdbc.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException("Failed to load mysql driver: "+ e);
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
//                DbConfig.getDatabaseUrl(),
                "jdbc:mysql://java-fall-sprint.cg16o4ceuq44.us-east-1.rds.amazonaws.com:3306/?useSSL=false&serverTimezone=UTC",
                DbConfig.getDatabaseUser(),
                DbConfig.getDatabasePassword()
        );
    }
}
