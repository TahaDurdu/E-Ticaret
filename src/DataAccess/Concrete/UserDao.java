package DataAccess.Concrete;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Abstract.UserDaoService;
import Entities.Concrete.User;

public class UserDao implements UserDaoService{

	List<User> users = new ArrayList <>();
	
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " Sisteme Kaydedildi");
		
	}

	@Override
	public boolean emailCheck(User user) {
		
		for(User u :users)
		
		if(u.geteMail()==user.geteMail()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean loginByCheck(String eMail, String passaword) {
		for(User user :users) {
			if(user.geteMail()== eMail && user.getPassaword() == passaword) {
				return true;
			}
		}
		return false;
	}

}
