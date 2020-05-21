package arvores;

public class Veiculo implements Comparable<Veiculo> {

	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		super();
		this.setPlaca(placa);
		this.setModelo(modelo);
		this.setAno(ano);
		this.setProprietario(proprietario);
	}

	public String toString() {
		return String.format("\nVeículo %s, placa %s, ano %s, de %s", this.modelo, this.placa, this.ano, this.proprietario);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public int compareTo(Veiculo veiculo) {
		return this.getPlaca().compareTo(veiculo.getPlaca());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo v = (Veiculo) obj;
		return this.getPlaca().equals(v.getPlaca());
	}
}