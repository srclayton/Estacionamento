package principal;

public class Cliente {
	private String nome;
	private int cpf;
	private String email;
	private int telefone;
	
	public Cliente(String nome,
				   int cpf,
				   String email,
				   int telefone){
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public int getCpf() {
		return cpf;
	}
	public int getTelefone() {
		return telefone;
	}
}