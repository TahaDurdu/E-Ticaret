package Core.Concrete;

import Core.Abstract.InputVerificationService;
import Entities.Concrete.User;
import GoogleUser.JGoogleUserIValid;

public class JGoogleUserVerificationServiceAdepter implements InputVerificationService {

	@Override
	public boolean �sValid(User user) {
		
	        JGoogleUserIValid googleuservalid=  new JGoogleUserIValid();
		return googleuservalid.�sVaid();
	}

}
