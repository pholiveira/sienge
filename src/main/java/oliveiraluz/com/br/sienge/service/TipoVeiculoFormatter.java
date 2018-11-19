package oliveiraluz.com.br.sienge.service;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import oliveiraluz.com.br.sienge.model.TipoVeiculo;

@Service
public class TipoVeiculoFormatter implements Formatter<TipoVeiculo> {

	@Autowired
	private TipoVeiculoService tipoVeiculoService;
	
	@Override
	public String print(TipoVeiculo object, Locale locale) {
		return (object != null ? object.getVeiculo() : "");
	}

	@Override
	public TipoVeiculo parse(String text, Locale locale) throws ParseException {
		TipoVeiculo retorno = this.tipoVeiculoService.findAll().stream().filter(tipo -> tipo.getVeiculo().equals(text)).findFirst().orElse(null);
		return retorno;
	}
}
