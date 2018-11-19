package oliveiraluz.com.br.sienge.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formulario {

	private Integer rodoviaPavimentada;
	private Integer rodoviaNaoPavimentada;
	private Integer cargaTransportada;
	private TipoVeiculo tipoVeiculo;

	private BigDecimal totalDistancia;
	private BigDecimal totalComplementar;

	public Formulario() {
		this.totalDistancia = new BigDecimal(0);
		this.totalComplementar = new BigDecimal(0);
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

	public Integer getCargaTransportada() {
		return cargaTransportada;
	}

	public void setCargaTransportada(Integer cargaTransportada) {
		this.cargaTransportada = cargaTransportada;
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

	public BigDecimal getTotalComplementar() {
		return totalComplementar.setScale(2, RoundingMode.HALF_UP);
	}

	public void setTotalComplementar(BigDecimal totalComplementar) {
		if (totalComplementar != null) {
			this.totalComplementar = totalComplementar;
		} else {
			this.totalComplementar = new BigDecimal(0);
		}
	}

	public BigDecimal getTotal() {
		return totalDistancia.add(totalComplementar).setScale(2, RoundingMode.HALF_UP);
	}
}
