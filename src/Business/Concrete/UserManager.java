package Business.Concrete;

import Business.Abstract.UserService;
import Core.Abstract.InputVerificationService;
import Core.Abstract.ValidatorService;
import DataAccess.Abstract.UserDaoService;
import Entities.Concrete.User;

public class UserManager implements UserService{

	 InputVerificationService memberInformationValidation;
	    UserDaoService userDaoService;
	    ValidatorService validatorService;

	    public UserManager(InputVerificationService memberInformationValidation,
	                       UserDaoService userDaoService, ValidatorService validatorService) {
	        this.memberInformationValidation = memberInformationValidation;
	        this.userDaoService = userDaoService;
	        this.validatorService = validatorService;

	    }


	    @Override
	    public void register(User user) {
	        if (!memberInformationValidation.ýsValid(user)) {
	            System.out.println("Kullanýcý bilgileri yanlýþ formatta. Kayýt iþlemi BAÞARISIZ!!!");
	        } else if (!userDaoService.emailCheck(user)) {
	            System.out.println("Bu email adresi daha önce alýnmýþ ---> " + user.geteMail() + "\n" + "Kayýt iþlemi BAÞARISIZ!!!");

	        } else {
	            userDaoService.add(user);
	            validatorService.sendVarificationMail();
	        }
	    }

	    @Override
	    public void login(String email, String password) {
	        if (userDaoService.loginByCheck(email, password)) {
	            System.out.println("Giriþ Baþarýlý.");
	        } else {
	            System.out.println("Kullanýcý adý yanlýþ veya kullanýcý yok. Giriþ BAÞARISIZ!!!");
	        }
	    }

}
