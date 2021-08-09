package principal;

public class Camera {
	private Vaga vaga;
	private String identificador; //id da c�mera?
	private boolean gravando; //s� grava quando um ve�culo for estacionado na vaga

	public Camera(Vaga vaga, String identificador, boolean gravando) {
		this.vaga = vaga;
		this.identificador = identificador;
		this.gravando = gravando;
	}
	
	public final Vaga getVaga() {
		return this.vaga;
	}
	
	public boolean getGravando() {
		return this.gravando;
	}
	
	public void setGravando(boolean gravando) {
		this.gravando = gravando;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
}
