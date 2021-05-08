package Business.Abstract;

import Entities.Concrete.User;

public interface UserService {

	void register(User user);
	void login(String eMail ,String passaword);
}
