package jdbc.utils;
import io.github.cdimascio.dotenv.Dotenv;
public class DbConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static void main(String[] args)
    {
        System.out.println(dotenv.get("KEY"));
    }
}
