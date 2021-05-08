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
	        if (!memberInformationValidation.�sValid(user)) {
	            System.out.println("Kullan�c� bilgileri yanl�� formatta. Kay�t i�lemi BA�ARISIZ!!!");
	        } else if (!userDaoService.emailCheck(user)) {
	            System.out.println("Bu email adresi daha �nce al�nm�� ---> " + user.geteMail() + "\n" + "Kay�t i�lemi BA�ARISIZ!!!");

	        } else {
	            userDaoService.add(user);
	            validatorService.sendVarificationMail();
	        }
	    }

	    @Override
	    public void login(String email, String password) {
	        if (userDaoService.loginByCheck(email, password)) {
	            System.out.println("Giri� Ba�ar�l�.");
	        } else {
	            System.out.println("Kullan�c� ad� yanl�� veya kullan�c� yok. Giri� BA�ARISIZ!!!");
	        }
	    }

}
