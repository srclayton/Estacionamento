package principal;

public abstract class Vaga {
	private String localizacao;
	private Camera camera;
	private Ocupacao ocupacao = null;

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
	
}
