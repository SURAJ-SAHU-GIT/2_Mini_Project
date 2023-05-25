package in.suraj.service;

import in.suraj.binding.LoginForm;
import in.suraj.binding.SignUpForm;
import in.suraj.binding.UnlockForm;

public interface UserService {
	
String createUser(SignUpForm form);
	
	String unlockAccount(UnlockForm form);
	
	String resetPassword(String email);
	
	String loginUser(LoginForm form);


}
