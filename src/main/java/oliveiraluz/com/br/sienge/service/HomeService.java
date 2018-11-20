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

	@Value("${parametro.toneladaExcedente}")
	private BigDecimal toneladaExcedente;
	
	/**
	 * Executa toda regra de negócio referente ao cálculo do transporte.
	 * 
	 * @param formulario
	 */
	public void calcularFormulario(Formulario formulario) {
		BigDecimal valorDistancia = calculaDistancia(formulario.getRodoviaPavimentada(), formulario.getRodoviaNaoPavimentada());
		
		Integer kmRodado = 0;
		
		if (formulario.getRodoviaPavimentada() != null)
			kmRodado += formulario.getRodoviaPavimentada();
		if (formulario.getRodoviaNaoPavimentada() != null)
			kmRodado += formulario.getRodoviaNaoPavimentada();
		
		BigDecimal valorAdicional = calculaAdicional(formulario.getTipoVeiculo(), valorDistancia, kmRodado, formulario.getCarga());

		formulario.setTotalDistancia(valorDistancia);
		formulario.setTotalAdicional(valorAdicional);
	}

	/**
	 * Contém regras especificas para calculos referente a distância.
	 * 
	 * @param rodoviaPavimentada
	 * @param rodoviaNaoPavimentada
	 * @return
	 */
	private BigDecimal calculaDistancia(Integer rodoviaPavimentada, Integer rodoviaNaoPavimentada) {
		BigDecimal valorTotal = new BigDecimal(0);

		if (rodoviaPavimentada != null) {
			valorTotal = this.pavimentado.multiply(new BigDecimal(rodoviaPavimentada));
		}
		if (rodoviaNaoPavimentada != null) {
			valorTotal = valorTotal.add(this.naoPavimentado.multiply(new BigDecimal(rodoviaNaoPavimentada)));
		}

		return valorTotal;
	}

	/**
	 * Contém regras especificas para calculos de adicionais.
	 * 
	 * @param tipoVeiculo
	 * @param valorTotalRodovia
	 * @param kmRodado
	 * @param carga
	 * @return
	 */
	private BigDecimal calculaAdicional(TipoVeiculo tipoVeiculo, BigDecimal valorTotalRodovia, Integer kmRodado, Integer carga) {
		BigDecimal valorTotal = new BigDecimal(0);

		if (tipoVeiculo != null) {
			valorTotal = tipoVeiculo.getFatorMultiplicador().multiply(valorTotalRodovia).subtract(valorTotalRodovia);
		}
		if (carga != null && carga > this.pesoCarga) {
			Integer cargaExcedente = carga - this.pesoCarga;
			valorTotal = valorTotal.add(toneladaExcedente.multiply(new BigDecimal(cargaExcedente)).multiply(new BigDecimal(kmRodado)));
		}
		return valorTotal;
	}
}
