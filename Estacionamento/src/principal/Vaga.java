package principal;

public class Vaga {
	private String localizacao;
	private Camera camera;
	private Ocupacao ocupacao = null;
	
	public Vaga(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public Ocupacao getOcupacao() {
		return ocupacao;
	}
	
	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	
}
