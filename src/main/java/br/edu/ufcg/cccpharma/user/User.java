package br.edu.ufcg.cccpharma.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ufcg.cccpharma.role.Authority;

/**
 * An User object models the real users of CCCPharma system. Each user will be
 * unique identified by its e-mail address. Also, every user has a password and
 * authorities. The authorities will be used to select the features whose access
 * will be granted to the user. The users are described in one of our database
 * tables.
 * 
 * @author Douglas Pereira de Lima
 * @author Fanny Batista Vieira
 * @author Mateus de Lima Oliveira
 * @author Matheus Alves dos Santos
 * 
 * @since 2018-11-12
 * @version 1.0
 * 
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_authority",
	           joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "email"),
	           inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;

	/**
	 * Creates an User object with nulled attributes.
	 */
	public User() {}

	/**
	 * Creates an User object based on its e-mail address, password and granted
	 * system authority.
	 * 
	 * @param email     The e-mail address of the user.
	 * @param password  The password used by the user to access the system.
	 * @param authority The user authority on the system.
	 * 
	 */
	public User(String email, String password, Authority authority) {
		this.email = email;
		this.password = password;
		this.authorities.add(authority);
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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	/**
	 * Generates a hash code for the User object based on its e-mail address.
	 * 
	 * @return The generated hash code for the User object.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/**
	 * Verifies equality between the User object and the Object given as parameter.
	 * This equality will only exists if the given Object is an User object with the
	 * same "email" attribute value.
	 * 
	 * @param obj An object to be compared to the User.
	 * 
	 * @return A boolean that represents the comparison result.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	/**
	 * Generates a textual representation of the User object based on its e-mail
	 * address and system authority. For security reasons, the password is not used
	 * in the String created.
	 * 
	 * @return The textual representation of the User.
	 * 
	 */
	@Override
	public String toString() {
		return "E-mail: " + this.getEmail() + " - Authority: " + this.getAuthorities().toString();
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	
	@JsonIgnore
	public List<Authority> getRoles() {
		return this.authorities;
	}

}
