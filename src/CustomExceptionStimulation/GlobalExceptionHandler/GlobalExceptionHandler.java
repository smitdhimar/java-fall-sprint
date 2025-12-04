package CustomExceptionStimulation.GlobalExceptionHandler;

import CustomExceptionStimulation.CustomException.InvalidIdException;
import CustomExceptionStimulation.CustomException.UserNotFoundException;

public class GlobalExceptionHandler {
    public static ErrorResponse handler(Exception e) {

        if (e instanceof InvalidIdException){
            return new ErrorResponse(500, e.getMessage());
        }
        if (e instanceof UserNotFoundException){
            return new ErrorResponse(404, e.getMessage());
        }
        return new ErrorResponse(500, "Internal server error");
    }
}
