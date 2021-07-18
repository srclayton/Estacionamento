package principal;

public abstract class Vaga {
	private String localizacao;
	boolean coberta;
	private Camera camera;
	private Veiculo veiculo = null;

	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public boolean isCoberta() {
		return coberta;
	}
	public void setCoberta(boolean coberta) {
		this.coberta = coberta;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}
