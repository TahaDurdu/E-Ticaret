package DataAccess.Abstract;

import Entities.Concrete.User;

public interface UserDaoService {

	void add(User user);
	boolean emailCheck(User user);
	boolean loginByCheck(String eMail, String passaword);
}
