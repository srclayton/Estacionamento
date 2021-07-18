package principal;

public class Camera {
	Vaga vaga;
	String identificador; //id da câmera?
	boolean gravando; //só grava quando um veículo for estacionado na vaga

	Camera(Vaga vaga, String identificador, boolean gravando) {
		this.vaga = vaga;
		this.identificador = identificador;
		this.gravando = gravando;
	}
	
	final Vaga getVaga() {
		return this.vaga;
	}
	
	boolean getGravando() {
		return this.gravando;
	}
	
	void setGravando(boolean gravando) {
		this.gravando = gravando;
	}
	
	String getIdentificador() {
		return this.identificador;
	}
	
}
