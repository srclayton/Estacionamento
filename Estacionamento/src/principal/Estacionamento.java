package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import principal.Veiculo.Tamanho;

public class Estacionamento {
	private Map<String, Cliente> mapaClientes = new HashMap<>(); //mapa cpf -> cliente
	private List<Vaga> listaVagas = new ArrayList<>();
	private List<Vaga> vagasOcupadas = new ArrayList<>();
	private Map<String, Veiculo> mapaVeiculos = new HashMap<>();
	private List<Ocupacao> listaOcupacao = new ArrayList<>();
	
	public Estacionamento() {
		
	}
	
	public Veiculo cadastraNovoVeiculo(String modelo, String placa, String cor, Tamanho tamanho, String avarias) {
		Veiculo v = new Veiculo(modelo, placa, cor, tamanho, avarias);
		mapaVeiculos.put(v.getPlaca(), v);
		return v;
	}

	public Cliente cadastraNovoCliente(String nome, String cpf, String email, String telefone) {
		Cliente c = new Cliente(nome, cpf, email, telefone);
		mapaClientes.put(c.getCpf(), c);
		return c;
	}

	public void adicionaCliente(Cliente cliente) {
		mapaClientes.put(cliente.getCpf(), cliente);
	}
	
	public Cliente getCliente(String cpf) {
		return mapaClientes.get(cpf);
	}

	public List<Vaga> getListaVagas() {
		return listaVagas;
	}

	public void adicionaVeiculo(Veiculo veiculo) {
		mapaVeiculos.put(veiculo.getPlaca(), veiculo);
	}
	
	public Veiculo getVeiculo(String placa) {
		return mapaVeiculos.get(placa);
	}

}
