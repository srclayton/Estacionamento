import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import principal.Estacionamento;
import principal.Gerenciador;

public class databaseTest {

	@Test
	public void setToDatabase() {
		Gerenciador ger = new Gerenciador();
		ger.cadastraNovoCliente("Lucas", "12255371932", "lucas.exemplo@gmail.com", "4002-8922");
		ger.cadastraNovoCliente("Gabriel", "12212371932", "gabriel.exemplo@gmail.com", "4002-8922");
		ger.cadastraNovoVeiculo("Ford fusion", "ABS-1823", "Preto", "Medio", "");
		ger.novaOcupacao(ger.getCliente("122.553.719.32"), ger.getVeiculo("ABS-1823"));
		ger.novaOcupacao(ger.getCliente("122.123.719.32"), ger.getVeiculo("ABS-1823"));
		ger.salvaBancoDeDados();
	}

	@Test
	public void getFromDatabase() {
		Gerenciador ger = new Gerenciador();
		ger.recuperaBancoDeDados();
		assertNotNull(ger.getEstacionamento().getCliente("12255371932"));
	}

}
