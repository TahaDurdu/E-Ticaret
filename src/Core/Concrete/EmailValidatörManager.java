package Core.Concrete;

import Core.Abstract.ValidatorService;

public class EmailValidat�rManager implements ValidatorService {

	@Override
	public void sendVarificationMail() {
		System.out.println("Do�rulama maili yolland�.");
		
	}

}
