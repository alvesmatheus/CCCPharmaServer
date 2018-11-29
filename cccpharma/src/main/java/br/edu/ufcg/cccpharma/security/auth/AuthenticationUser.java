package br.edu.ufcg.cccpharma.security.auth;

public class AuthenticationUser {
	
	private String email;
	
	private String password;
	
	public AuthenticationUser() {}
	
	public AuthenticationUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
