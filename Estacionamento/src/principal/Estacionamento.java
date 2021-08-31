package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import principal.Veiculo.Tamanho;

public class Estacionamento {
	@SuppressWarnings("unused")
	private ObjectId id;
	@BsonProperty("mapaClientes")
	private Map<String, Cliente> mapaClientes = new HashMap<>(); //mapa cpf -> cliente
	@BsonProperty("listaVagas")
	private List<Vaga> listaVagas = new ArrayList<>();
	@BsonProperty("vagasOcupadas")
	private List<Vaga> vagasOcupadas = new ArrayList<>();
	@BsonProperty("mapaVeiculos")
	private Map<String, Veiculo> mapaVeiculos = new HashMap<>();
	@BsonProperty("listaOcupacao")
	private List<Ocupacao> listaOcupacao = new ArrayList<>();
	
	
	public Estacionamento() {

	}
	@BsonCreator
	public Estacionamento(@BsonProperty("mapaClientes") Map<String, Cliente> mapaClientes,
			@BsonProperty("listaVagas") List<Vaga> listaVagas,
			@BsonProperty("vagasOcupadas") List<Vaga> vagasOcupadas,
			@BsonProperty("mapaVeiculos") Map<String, Veiculo> mapaVeiculos,
			@BsonProperty("listaOcupacao") List<Ocupacao> listaOcupacao) {
		this.mapaClientes = mapaClientes;
		this.listaVagas = listaVagas;
		this.vagasOcupadas = vagasOcupadas;
		this.mapaVeiculos = mapaVeiculos;
		this.listaOcupacao = listaOcupacao;
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
	
	public void adicionaOcupacao(Ocupacao ocupacao) {
		listaOcupacao.add(ocupacao);
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
	
	public List<Ocupacao> getListaOcupacao() {
		return listaOcupacao;
	}

}
