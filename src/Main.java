import Business.Abstract.UserService;
import Business.Concrete.UserManager;
import Core.Concrete.EmailValidatörManager;
import Core.Concrete.InputVerification;
import Core.Concrete.JGoogleUserVerificationServiceAdepter;
import DataAccess.Concrete.UserDao;
import Entities.Concrete.User;

public class Main {

	public static void main(String[] args) {
		
		User user1= new User(1,"Taha","Durdu","tahadurdu@hotmail.com","123456taha");
		User user2= new User(2,"Kerem","Durdu","Kerem25@hotmail.com","456789kerem");
		User user3 = new User(3,"Engin","Demiroð","Demiroð12@hotmail.com","engin7894");
		
		UserService userService = new UserManager(new InputVerification(), new UserDao(), new EmailValidatörManager());
        userService.register(user1);

        System.out.println("----------------------------------");

        userService.register(user1);

        System.out.println("----------------------------------");

        userService.register(user2);

        System.out.println("----------------------------------");

        userService.register(user3);

        System.out.println("----------------------------------");



        UserService userService2 = new UserManager(new JGoogleUserVerificationServiceAdepter(), new UserDao(), new EmailValidatörManager());
        userService2.register(user3);



        System.out.println("----------------------------------");

        userService.login("emirbekir97@hotmail.com", "123456"); // doðru girdiler

        System.out.println("----------------------------------");

        userService.login ("engindemiroð@gmail.com", "56565655225215448"); // yanlýþ parola




	}

}
