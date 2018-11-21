package oliveiraluz.com.br.sienge.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Formulario {
	private final NumberFormat brFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
	private Integer rodoviaPavimentada;
	private Integer rodoviaNaoPavimentada;
	private Integer carga;
	private String veiculo;

	private BigDecimal totalDistancia;
	private BigDecimal totalAdicional;

	public Formulario() {
		this.totalDistancia = new BigDecimal(0);
		this.totalAdicional = new BigDecimal(0);
	}

	public Integer getRodoviaPavimentada() {
		return rodoviaPavimentada;
	}

	public void setRodoviaPavimentada(Integer rodoviaPavimentada) {
		this.rodoviaPavimentada = rodoviaPavimentada;
	}

	public Integer getRodoviaNaoPavimentada() {
		return rodoviaNaoPavimentada;
	}

	public void setRodoviaNaoPavimentada(Integer rodoviaNaoPavimentada) {
		this.rodoviaNaoPavimentada = rodoviaNaoPavimentada;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getTotalDistancia() {
		return this.brFormat.format(totalDistancia.setScale(2, RoundingMode.HALF_UP));
	}

	public void setTotalDistancia(BigDecimal totalDistancia) {
		if (totalDistancia != null) {
			this.totalDistancia = totalDistancia;
		} else {
			this.totalDistancia = new BigDecimal(0);
		}
	}

	/**
	 * Formatação para exibição na tela.
	 * 
	 * @return
	 */
	public String getTotalAdicional() {
		return this.brFormat.format(totalAdicional.setScale(2, RoundingMode.HALF_UP));
	}

	public void setTotalAdicional(BigDecimal totalComplementar) {
		if (totalComplementar != null) {
			this.totalAdicional = totalComplementar;
		} else {
			this.totalAdicional = new BigDecimal(0);
		}
	}

	/**
	 * Formatação para exibição na tela.
	 * 
	 * @return
	 */
	public String getTotal() {
		return this.brFormat.format(totalDistancia.add(totalAdicional).setScale(2, RoundingMode.HALF_UP));
	}
}
