package jdbc.utils;
import io.github.cdimascio.dotenv.Dotenv;
public class DbConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getDatabaseUrl(){
        return dotenv.get("DB_ENDPOINT");
    }
    public static String getDatabaseUser(){
        return dotenv.get("DB_USER");
    }
    public static String getDatabasePassword(){
        return dotenv.get("DB_PASSWORD");
    }
}
