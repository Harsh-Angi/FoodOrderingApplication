package pizzaProject;

public class IncorrectOptionException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Please Choose a Correct Option";
	}
	

}
