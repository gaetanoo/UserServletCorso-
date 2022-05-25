import java.util.ArrayList;
import java.util.List;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;
import com.corso.service.ValidationUserException;

public class TestUser {
	public static void main(String[] args) {
		UserServiceImpl impl = new UserServiceImpl();
		
		
		//	impl.creaUtente("francesco", "francesco@", 25, "1998-12-10", "Italy");
		//	impl.cancellaUtente(3);
		//	impl.modificaUtente(1, "vittorio", "vittorio@", 30, "1992-10-10", "Italy");
			impl.getUser(1);
			
			for(User u : impl.visualizzaUtenti()) {
				System.out.println(u.toString());
			}
	}
}
