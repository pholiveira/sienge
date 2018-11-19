package oliveiraluz.com.br.sienge.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import oliveiraluz.com.br.sienge.model.TipoVeiculo;

@Service
public class TipoVeiculoService {

	/**
	 * Simula uma consulta ao banco
	 * 
	 * @return
	 */
	public List<TipoVeiculo> findAll() {
		return Arrays.asList(new TipoVeiculo("Caminhão baú", new BigDecimal(1.00)), new TipoVeiculo("Caminhão caçamba", new BigDecimal(1.05)), new TipoVeiculo("Carreta", new BigDecimal(1.12)));
	}
}
