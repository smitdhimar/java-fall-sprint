package jdbc.Crud;

import jdbc.utils.*;

import java.sql.*;

public class Crud {
    public static boolean createTable() {
        // Remove the USE statement - handle database selection in connection
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY, "
                + "NAME VARCHAR(100), "
                + "EMAIL VARCHAR(100))";

        try (
                Connection con = DatabaseConnection.getConnection();
                Statement stmt = con.createStatement();
        ) {
            // Use executeUpdate for DDL statements
            int result = stmt.executeUpdate(createTableQuery);
            System.out.println("SUCCESS: Table created successfully");
            return true;
        } catch (Exception e) {
            System.out.println("FAILURE: " + e.getMessage());
        }
        return false;
    }
    public static boolean checkConnection() {
        try (Connection con = DatabaseConnection.getConnection();) {
            System.out.println("SUCCESS: Connection established successful");


            return true;
        } catch (Exception e) {
            System.out.println("There is some problem in checkConnection() function: " + e);
        }
        return false;
    }
    public static void addUser(String name, String email) {
        String query = String.format("insert into users(name, email) values ('%s', '%s');", name, email);
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.execute();

        } catch (Exception e) {
            System.out.println("FAILURE: There was some error: " + e);
        }
    }
    public static void getAllUsers(){
        String query = "select * from users;";
        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()
                ){
            while(rs.next()){
                System.out.println(rs.getInt("id")+ "|" +
                                    rs.getString("name") + "|" +
                                    rs.getString("email"));
            }
        }
        catch (Exception e){
            System.out.println("FAILURE: Some error in getAllUsers(): "+ e);
        }
    }
    public static void deleteUser(int id){
        String query = String.format("delete from users where id = %d ", id);
        try(
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(query);
                ){
            stmt.execute();
        }
        catch (Exception e){
            System.out.println("FAILURE: Error while deleting User");
        }
    }
}
