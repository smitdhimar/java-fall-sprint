package jdbc;

import jdbc.Crud.Crud;

public class Main {
    public static void main(String[] args){
        boolean isConnection = Crud.checkConnection();
        System.out.println("isConnection: "+ isConnection);
    }
}
