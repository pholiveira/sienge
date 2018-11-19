package oliveiraluz.com.br.sienge.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import oliveiraluz.com.br.sienge.model.Formulario;
import oliveiraluz.com.br.sienge.model.TipoVeiculo;

@Service
public class HomeService {
	
	@Value("${parametro.pavimentado}")
	private BigDecimal pavimentado;

	@Value("${parametro.naoPavimentado}")
	private BigDecimal naoPavimentado;
	
	@Value("${parametro.pesoCarga}")
	private Integer pesoCarga;
	
	public void calcularFormulario(Formulario formulario) {
		BigDecimal valorDistancia = calculaDistancia(formulario.getRodoviaPavimentada(), formulario.getRodoviaNaoPavimentada());
		BigDecimal valorAdicional = calculaAdicional(formulario.getTipoVeiculo(), valorDistancia, formulario.getCarga());

		formulario.setTotalDistancia(valorDistancia);
		formulario.setTotalAdicional(valorAdicional);
	}
	
	private BigDecimal calculaDistancia(Integer rodoviaPavimentada, Integer rodoviaNaoPavimentada) {
		BigDecimal totalRodovia = new BigDecimal(0);
		
		if (rodoviaPavimentada != null) {
			totalRodovia = this.pavimentado.multiply(new BigDecimal(rodoviaPavimentada));
		}
		if (rodoviaNaoPavimentada != null) {
			totalRodovia = totalRodovia.add(this.naoPavimentado.multiply(new BigDecimal(rodoviaNaoPavimentada)));
		}
		
		return totalRodovia;
	}
	
	private BigDecimal calculaAdicional(TipoVeiculo tipoVeiculo, BigDecimal totalRodovia, Integer carga) {
		BigDecimal totalAdicional = new BigDecimal(0);
		
		if (tipoVeiculo != null) {
			totalAdicional = tipoVeiculo.getFatorMultiplicador().multiply(totalRodovia).subtract(totalRodovia);
		}
		if (carga > this.pesoCarga) {
			
		}
		return totalAdicional;
	}
}
