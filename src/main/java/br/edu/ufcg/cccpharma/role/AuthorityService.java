package br.edu.ufcg.cccpharma.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;

	public void save(Authority authority) {
		this.authorityRepository.save(authority);
	}

	public List<Authority> findAll(){
		return this.authorityRepository.findAll();
	}

}
