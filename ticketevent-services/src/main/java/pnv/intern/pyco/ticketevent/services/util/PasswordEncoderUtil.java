package pnv.intern.pyco.ticketevent.services.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

	public static String endCodePassword(String password) {
		PasswordEncoder md5 = new BCryptPasswordEncoder();  
		String strEncodedPassword = md5.encode(password);
		return strEncodedPassword;
	}

}
