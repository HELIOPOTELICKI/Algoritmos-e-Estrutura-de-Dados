
public class Veiculo implements Comparable<String> {
	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.proprietario = proprietario;
	}
	
	public Veiculo() {
		super();
	}

	public String toString() {
		return String.format("Veículo %s, placa %s, ano %s, de %s \n", this.modelo, this.placa, this.ano,
				this.proprietario);
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
    public int compareTo(String outro) {
       return (this.getPlaca().compareTo(outro));
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getPlaca().compareTo((String) obj) == 0);
    }
}