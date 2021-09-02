import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import principal.Estacionamento;
import principal.Gerenciador;
import principal.Vaga;

public class databaseTest {

	@Test
	public void setToDatabase() {
		Gerenciador ger = new Gerenciador();
		ger.novaOcupacao(ger.cadastraNovoCliente("Lucas André", "12255371932", "lucas.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("Ford fusion", "ABS-1823", "Preto", "Medio", ""), new Vaga("A-1"));
		
		ger.novaOcupacao(ger.cadastraNovoCliente("Gabriel", "12212371932", "gabriel.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("Volkswagen gol", "GSA-1134", "Vermelho", "Medio", ""), new Vaga("A-2"));
		
		ger.novaOcupacao(ger.cadastraNovoCliente("Clayton", "12255371932", "lucas.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("GM Corsa", "TAG-1313", "Branco", "Medio", ""), new Vaga("A-3"));
		
		ger.novaOcupacao(ger.cadastraNovoCliente("Lucas Perin", "12212371932", "perin.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("Fusca", "CLB-3195", "Azul", "Medio", ""), new Vaga("A-4"));
		
		ger.novaOcupacao(ger.cadastraNovoCliente("Gabriel", "12212371932", "gabriel.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("CG-125", "FSA-9091", "Preto", "Medio", ""), new Vaga("A-5"));
		
		ger.novaOcupacao(ger.cadastraNovoCliente("Gabriel", "12212371932", "gabriel.exemplo@gmail.com", "4002-8922"),
				ger.cadastraNovoVeiculo("CG-125", "FSA-9091", "Preto", "Medio", ""), new Vaga("A-6"));
		
		for(int i = 7; i < 20; i++)
		{
			String aux = "A-" + Integer.toString(i);
			Vaga c = new Vaga(aux);
			ger.getEstacionamento().getListaVagas().add(c);
		}
		ger.salvaBancoDeDados();
	}

	@Test
	public void getFromDatabase() {
		Gerenciador ger = new Gerenciador();
		ger.recuperaBancoDeDados();
		assertNotNull(ger.getEstacionamento().getCliente("12255371932"));
	}

}
