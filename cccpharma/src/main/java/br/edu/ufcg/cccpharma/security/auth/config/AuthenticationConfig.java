package br.edu.ufcg.cccpharma.security.auth.config;

public enum AuthenticationConfig {
	HEADER("Authentication"),
	TOKEN_PREFIX("Bearer"),
	TOKEN("token");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private AuthenticationConfig(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Método usado para obter o valor do enum.
	 * @return String o valor do enum escolhido
	 */
	public String toString(){
		return this.descricao;
	}
}
