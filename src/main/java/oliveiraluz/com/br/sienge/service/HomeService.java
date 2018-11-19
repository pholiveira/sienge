package oliveiraluz.com.br.sienge.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import oliveiraluz.com.br.sienge.model.Formulario;
import oliveiraluz.com.br.sienge.model.Parametro;
import oliveiraluz.com.br.sienge.model.TipoVeiculo;

@Service
public class HomeService {
	
	public void calcularFormulario(Formulario formulario) {
		BigDecimal valorDistancia = calculaDistancia(formulario.getRodoviaPavimentada(), formulario.getRodoviaNaoPavimentada());
		BigDecimal valorAdicional = calculaAdicional(formulario.getTipoVeiculo(), valorDistancia);

		formulario.setTotalDistancia(valorDistancia);
		formulario.setTotalComplementar(valorAdicional);
	}
	
	private BigDecimal calculaDistancia(Integer rodoviaPavimentada, Integer rodoviaNaoPavimentada) {
		BigDecimal totalRodovia = new BigDecimal(0);
		
		if (rodoviaPavimentada != null) {
			totalRodovia = Parametro.PAVIMENTADA.multiply(new BigDecimal(rodoviaPavimentada));
		}
		if (rodoviaNaoPavimentada != null) {
			totalRodovia = totalRodovia.add(Parametro.NAO_PAVIMENTADA.multiply(new BigDecimal(rodoviaNaoPavimentada)));
		}
		
		return totalRodovia;
	}
	
	private BigDecimal calculaAdicional(TipoVeiculo tipoVeiculo, BigDecimal totalRodovia) {
		BigDecimal totalAdicional = new BigDecimal(0);
		
		if (tipoVeiculo != null) {
			totalAdicional = totalRodovia.subtract(tipoVeiculo.getFatorMultiplicador().multiply(totalRodovia));
		}
		
		return totalAdicional;
	}
}
