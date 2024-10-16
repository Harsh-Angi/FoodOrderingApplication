package pizzaProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	static ArrayList<User> list= new ArrayList<User>();
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		list.add(new User("admin",123));
		startingMethods();
		
		}
		
	public static void startingMethods() {
		System.out.println("Press 1 To Create New Account");
		System.out.println("Press 2 To Login To Existing Account");
		
		
		
		try{
			int i=sc.nextInt();
			
			switch (i) {
			case 1: {
				createUser();
				break;
			}
			
			case 2:{
				login();
				break;
				
			}
			default:{
				try {
					throw new IncorrectOptionException();
				}
				catch(IncorrectOptionException e) {
				System.out.println(e.getMessage());
				startingMethods();
				break;
				}
			}}
		}
		catch(InputMismatchException e) {
			System.out.println("Please Enter a Valid Number Only");
			sc.nextLine();
			startingMethods();
		}
		
	}
	
//	Create user then login
	
	
	public static void createUser() {
		String username;
		int pwd;
		try {
		System.out.println("Enter Username");
		username= sc.next();
		System.out.print("Enter Password");
		pwd= sc.nextInt();
		list.add(new User(username,pwd));
		System.out.println("Account Created Successfully!!");
		System.out.println("Now login to your account");
		login();
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input...Try Again");
			sc.nextLine();
			createUser();
		}
		
			
	}
	
	public static void login() {
		String username;
		int pwd;
		boolean found=false;
		try {
			
			System.out.println("Enter Username");
			username= sc.next();
			
			System.out.print("Enter Password");
			pwd= sc.nextInt();
			
			for(User s:list) {
				if(username.equals(s.getUser()) && pwd == s.getPwd()) {
					System.out.println("Login Successfull");
					found=true;
					sc.nextLine();
					doNext(username);
					
					break;
					
					
				}
				}
			try {
			if(!found) {
				
				throw new UserNotFoundException();
				
			}}
			catch(UserNotFoundException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				tryAgain();
			}
				
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Type of  password...Try Again");
				sc.nextLine();
				tryAgain();
			}
			}
		
		
	
	public static void tryAgain() {
		System.out.println("Press 1 To Create New User");
		System.out.println("Press 2 to try Login again");
		int i= sc.nextInt();
		
		switch(i) {
		case 1:{
			sc.nextLine();
			createUser();
		}
		case 2:{
			sc.nextLine();
			login();
		}
		default:{
			try {
			throw new IncorrectOptionException();
			}
			catch(IncorrectOptionException ie) {
			System.out.println(ie.getMessage());
			sc.nextLine();
			tryAgain();
		}}
		}
	}
	
	public static void addBalance(String username) {
		System.out.println("Enter the amount you want to add");
		try{double bal= sc.nextDouble();
		for(User u: list) {
			if(u.getUser().equals(username)) {
				u.addBal(bal);
				System.out.println("Balance Added Successfully...Your new balance is:" +u.getBal());
				break;
			}
		}
		doNext(username);
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter a correct amount");
			sc.nextLine();
			addBalance(username);
		}
		
	}
	
	public static void doNext(String username) {
		System.out.println("Press 1 If you want to add balance to your account");
		System.out.println("Press 2 to Check Balance");
		System.out.println("Press 3 If you want to order pizza");
		System.out.println("Press 4 to LogOut");
		try {
		int i=sc.nextInt();
		
		switch(i) {
		case 1:{
			sc.nextLine();
			addBalance(username);
			break;
		}
		
		case 2:{
			sc.nextLine();
			fetchBalance(username);
			break;
			
		}
		
		case 3:{
			sc.nextLine();
			orderPizza(username);
			break;
			
		}
		case 4:{
			System.out.println("Logged Out");
			sc.nextLine();
			startingMethods();
			break;
		}
		default:{
			System.out.println("Choose a correct option");
			sc.nextLine();
			doNext(username);
		}
		}}
		catch(InputMismatchException e) {
			System.out.println("Please Enter Number Only");
			sc.nextLine();
			doNext(username);
		}
	}
	
	public static void orderPizza(String username) {
		System.out.println("1. Margherita Pizza 200Rs");
		System.out.println("2. Panner Pizza 300Rs");
		System.out.println("3. Tandoori Pizza 250Rs");
		
		
		try {
			int i;
			i=sc.nextInt();
		
		double price=0;
		
		
		switch(i) {
		case 1:{
			price=200;
			break;
		}
		case 2:{
			price=300;
			break;
		}
		case 3:{
			price=250;
			break;
		}
		default:{
			try {
				throw new IncorrectOptionException();
			}
			catch(IncorrectOptionException ie){
			System.out.println(ie.getMessage());
			sc.nextLine();
			orderPizza(username);
		}}
		}
		
		for(User u:list) {
			if(u.getUser().equals(username)) {
				if(u.getBal()>=price) {
					u.addBal(-price);
					
					System.out.println("Pizza Ordered SuccessFully...Your New Balance is:" + u.getBal());
				}
				else {
					try {
					throw new InsufficientBalanceException();
					}
					catch(InsufficientBalanceException e) {
						System.out.println(e.getMessage());
						System.out.println("Please Add Balance");
						sc.nextLine();
						doNext(username);
						
					}}
				sc.nextLine();
				doNext(username);
			}
		}
		}
		catch(InputMismatchException e) {
			System.out.println("Please Enter Number Only");
			sc.nextLine();
			orderPizza(username);
		}
	
}
	public static void fetchBalance(String username) {
		for(User u: list) {
			if(u.getUser().equals(username)) {
				System.out.println("Your Current Balance is: "+u.getBal());
				break;
				
				
			}
			else {
				try {
					throw new UserNotFoundException();
				}
				catch(UserNotFoundException e) {
					System.out.println(e.getMessage());
					doNext(username);
				}
			}
		}
		doNext(username);
		

	}
}