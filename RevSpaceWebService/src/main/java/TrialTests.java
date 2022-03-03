import com.revature.revspace.controllers.UserController;
import com.revature.revspace.models.User;
import com.revature.revspace.services.UserServiceImpl;

public class TrialTests {

	public static void main(String[] args) {
		UserServiceImpl uServ = new UserServiceImpl();
		UserController userCont = new UserController();
		User david = uServ.get(41);
		User nick = uServ.get(44);
		
		System.out.println(david);
		
		System.out.println(userCont.followUser(Integer.valueOf(nick.getUserId()).toString(), david));
		
		System.out.println(david);

	}

}
