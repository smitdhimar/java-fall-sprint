package CustomExceptionStimulation;

import CustomExceptionStimulation.GlobalExceptionHandler.ErrorResponse;
import CustomExceptionStimulation.GlobalExceptionHandler.GlobalExceptionHandler;
import CustomExceptionStimulation.UserController.UserController;

public class Main {
    public static void main (String[] args){
        try{
            String response = UserController.getUser(10);
            System.out.println(response);
        }
        catch (Exception e){
            ErrorResponse error = GlobalExceptionHandler.handler(e);
            System.out.println("Error: "+ error.getStatus() + " - " + error.getMessage());
        }
    }
}
