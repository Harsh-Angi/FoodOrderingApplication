package pizzaProject;

public class InsufficientBalanceException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Balance is Not Enough";
	}
}
