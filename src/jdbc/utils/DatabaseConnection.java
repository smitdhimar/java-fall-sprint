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
                DbConfig.getDatabaseUrl(),
                DbConfig.getDatabaseUser(),
                DbConfig.getDatabasePassword()
        );
    }
}
