package pnv.intern.pyco.ticketevent;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CusAuthenticationProvider implements AuthenticationProvider {
	
	public CusAuthenticationProvider() {
		
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (name != null && password != null) {
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authentication.getAuthorities());
            return auth;
        } else {
            return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
