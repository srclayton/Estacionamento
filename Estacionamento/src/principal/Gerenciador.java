package principal;

import java.util.ArrayList;
import java.util.List;

import principal.Veiculo.Tamanho;

public class Gerenciador {
	private Estacionamento estacionamento;
	private Conexao conexao;
	private List<Ocupacao> listaOcupacao = new ArrayList<>();
	private final static int PORTA_CONEXAO = 2565;
	
	public Gerenciador() {
		estacionamento = new Estacionamento();
		conexao = new Conexao(PORTA_CONEXAO);
		recuperaBancoDeDados();
	}
	
	public void recuperaBancoDeDados() {
		// TODO
		
	}

	public Veiculo cadastraNovoVeiculo(String modelo, String placa, String cor, String tamanho, String avarias) {
		return estacionamento.cadastraNovoVeiculo(modelo, placa, cor, Tamanho.valueOf(tamanho.toUpperCase()), avarias);
	}
	
	public Cliente cadastraNovoCliente(String nome, String cpf, String email, String telefone) {
		return estacionamento.cadastraNovoCliente(nome, cpf, email, telefone);
	}
	
	public void novaOcupacao(Cliente cliente, Veiculo veiculo) {
		float valorDiaria = (float) 20.0;//????
		Ocupacao ocupacao = new Ocupacao(cliente, veiculo, valorDiaria);
		listaOcupacao.add(ocupacao);
	}

	public List<Ocupacao> getListaOcupacao() {
		return listaOcupacao;
	}

	public Cliente getCliente(String cpf) {
		return estacionamento.getCliente(cpf);
	}
	
	public Veiculo getVeiculo(String placa) {
		return estacionamento.getVeiculo(placa);
	}
}
