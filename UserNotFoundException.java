package pizzaProject;

public class UserNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "No User Found...Check Your Username or Password Or Create a New Account";
	}
}
