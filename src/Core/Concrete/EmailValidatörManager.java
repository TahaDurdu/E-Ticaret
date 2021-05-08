package Core.Concrete;

import Core.Abstract.ValidatorService;

public class EmailValidatörManager implements ValidatorService {

	@Override
	public void sendVarificationMail() {
		System.out.println("Doðrulama maili yollandý.");
		
	}

}
