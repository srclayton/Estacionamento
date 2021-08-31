package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import javafx.collections.ObservableList;

import org.bson.Document;

import com.google.gson.Gson;

import principal.Veiculo.Tamanho;

public class Gerenciador {
	private Estacionamento estacionamento;
	private transient static Gson GSON = new Gson();
	//private final static int PORTA_CONEXAO = 2565;
	
	static {

	}
	
	public Gerenciador() {
		estacionamento = new Estacionamento();
		//recuperaBancoDeDados();
	}
	
	public void recuperaBancoDeDados() {
		
		
		
		//Conexao.getInstance().testando();
		String dbData = Conexao.getInstance().getDatabaseJsonAsString();
		this.estacionamento = GSON.fromJson(dbData, Estacionamento.class);
	}
	
	/*public void salvaBancoDeDados() {
		String dbData = GSON.toJson(this);
		System.out.println(dbData);
		try {
			conexao.salvaBancoDeDados(dbData);
		} catch(Exception e) {
			
		}
		
	}*/
	public void salvaBancoDeDados() {
		try {
			Conexao.getInstance().salvaBancoDeDados(estacionamento);			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
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
		estacionamento.adicionaOcupacao(ocupacao);
	}

	public Cliente getCliente(String cpf) {
		return estacionamento.getCliente(cpf);
	}
	
	public Veiculo getVeiculo(String placa) {
		return estacionamento.getVeiculo(placa);
	}
	
	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}
}
