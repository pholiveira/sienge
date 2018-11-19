package oliveiraluz.com.br.sienge.model;

import java.math.BigDecimal;

public class TipoVeiculo {

	private String veiculo;
	private BigDecimal fatorMultiplicador;

	public TipoVeiculo() {
	}

	public TipoVeiculo(String veiculo, BigDecimal fatorMultiplicador) {
		this.veiculo = veiculo;
		this.fatorMultiplicador = fatorMultiplicador;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public BigDecimal getFatorMultiplicador() {
		return fatorMultiplicador;
	}

	public void setFatorMultiplicador(BigDecimal fatorMultiplicador) {
		this.fatorMultiplicador = fatorMultiplicador;
	}

	@Override
	public String toString() {
		return "TipoVeiculo [veiculo=" + veiculo + ", fatorMultiplicador=" + fatorMultiplicador + "]";
	}
}
