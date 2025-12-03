package jdbc;

import jdbc.Crud.Crud;

public class Main {
    public static void main(String[] args){
        boolean isConnection = Crud.checkConnection();

        if(isConnection){
//            Crud.createTable();
//            Crud.addUser("Smit", "smitdhimar61@gmail.com");
            Crud.deleteUser(1);
            Crud.getAllUsers();
        }
    }
}
