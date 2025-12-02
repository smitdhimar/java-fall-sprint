package jdbc.Crud;

import jdbc.utils.*;
import java.sql.*;

public class Crud {
    public static boolean checkConnection(){
        try(Connection con = DatabaseConnection.getConnection();){
            System.out.println("SUCCESSS: Connection established successfull");


            return true;
        }
        catch (Exception e){
            System.out.println("There is some problem in checkConnection() function: "+ e);
        }
        return false;
    }
}
