package CustomExceptionStimulation.UserController;

import CustomExceptionStimulation.CustomException.InvalidIdException;
import CustomExceptionStimulation.CustomException.UserNotFoundException;

public class UserController {
    public static String getUser(int id){
        if(id < 0){
            throw new InvalidIdException("Invalid ID , please enter valid id");
        }
        if(id > 100){
            throw new UserNotFoundException("User Not Found");
        }
        return "user: "+ id;
    }
}
