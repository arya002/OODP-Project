
public class LogIn {

	public LogIn() {

	}
	
	public static String checkLogin(String username, String password){
		String retVal = "";
		
		if (username.equals("user1")){
			retVal = "sourcePathKey to get correct file";
			//user the return value != "" to then load user from LoadUser
			//alternatively have the login terminal like check user+pass responses and calls in here
		}
		
		return retVal;
	}
	
	//staff register has to be done by another staff member?
	
	public static User Register(String user_,String pass_,String PhoneNum, String email) {
		
		//if(someone else doesnt have same username)
			//add this new user to database
			//return an instance of the ClientClass
		
		return null;
		
	}
	
	public static User loadUser(String SourcePathKey) {
		
		//load from the database files and return as a
		
		return new Client("name","pass","email", "phonenum", "name");
	}

}
