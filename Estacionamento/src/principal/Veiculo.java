package principal;

public class Veiculo {
	public enum Tamanho {
		PEQUENO("Veiculo pequeno"),
		MEDIO("Veiculo medio"),
		GRANDE("Veiculo grande");
		
		private String str;
		Tamanho(String str) {
			this.str = str;
		}
		
		public String toString() {
			return str;
		}
		
	}
	private String modelo;
	private String placa;
	private String cor;
	private Tamanho tamanho;
	private String avarias;

	public Veiculo(String modelo, String placa, String cor, Tamanho tamanho, String avarias) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.tamanho = tamanho;
		this.avarias = avarias;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public String getAvarias() {
		return avarias;
	}

	public void setAvarias(String avarias) {
		this.avarias = avarias;
	}
	
}
