package oliveiraluz.com.br.sienge.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formulario {

	private Integer rodoviaPavimentada;
	private Integer rodoviaNaoPavimentada;
	private Integer carga;
	private TipoVeiculo tipoVeiculo;

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

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public BigDecimal getTotalDistancia() {
		return totalDistancia.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTotalDistancia(BigDecimal totalDistancia) {
		if (totalDistancia != null) {
			this.totalDistancia = totalDistancia;
		} else {
			this.totalDistancia = new BigDecimal(0);
		}
	}

	public BigDecimal getTotalAdicional() {
		return totalAdicional.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTotalAdicional(BigDecimal totalComplementar) {
		if (totalComplementar != null) {
			this.totalAdicional = totalComplementar;
		} else {
			this.totalAdicional = new BigDecimal(0);
		}
	}

	public BigDecimal getTotal() {
		return totalDistancia.add(totalAdicional).setScale(2, RoundingMode.HALF_UP);
	}
}
