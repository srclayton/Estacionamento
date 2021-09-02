package principal;

public class Cliente {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Veiculo veiculo;
    private Vaga vaga = null;
	
	public Cliente(String nome, String cpf, String email, String telefone) {
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
	
	public String getCpf() {
		return cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
        
        public void setVaga(Vaga vaga) {
            this.vaga = vaga;
        }
}
