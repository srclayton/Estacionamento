package principal;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Ocupacao {
	private Date dataInicio;
	private float valorDiaria;
	private Cliente cliente;
	private Veiculo veiculo;
	private Date agendamentoLavaRapido = null;
	
	Ocupacao(Cliente cliente, Veiculo veiculo, float valorDiaria) {
		this.cliente = cliente;
		this.valorDiaria = valorDiaria;
		this.veiculo = veiculo;
		dataInicio = new Date();
	}
	
	public float getValorAtual() {
		int dias = contaDias(dataInicio, new Date());
		return dias > 0 ? valorDiaria*dias : valorDiaria;
	}
	
	/**
	 * @return quantos dias se passaram entre data d1 e data d2
	 */
    public static int contaDias(Date d1, Date d2) {
        return (int)((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
	
    /**
     * 
     * @param dataFim: representa a data do fim da estadia, para o orçamento.
     * @param valorDiaria
     * 
     * @return valor total do orçamento
     */
	public static float getValor(Date dataFim, float valorDiaria) {
		return contaDias(new Date(), dataFim) * valorDiaria;
	}
	
	public boolean temAgendamentoLavaRapido() {
		return agendamentoLavaRapido != null;
	}
	
	public Date getAgendamentoLavaRapido() {
		return agendamentoLavaRapido;
	}
	
}
