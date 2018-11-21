package oliveiraluz.com.br.sienge;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import oliveiraluz.com.br.sienge.application.SiengeApplication;
import oliveiraluz.com.br.sienge.model.Formulario;
import oliveiraluz.com.br.sienge.service.HomeService;
import oliveiraluz.com.br.sienge.service.TipoVeiculoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SiengeApplication.class)
public class SiengeApplicationTests {
	private final NumberFormat brFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private TipoVeiculoService tipoVeiculoService;
	
	@Test
	public void calculaRodovia() {
		Formulario formulario = new Formulario();
		formulario.setRodoviaPavimentada(80);
		formulario.setRodoviaNaoPavimentada(20);
		homeService.calcularFormulario(formulario);
		String resultExpected = brFormat.format(new BigDecimal(55.60));
		assertEquals(resultExpected, formulario.getTotal());
	}

	@Test
	public void calculaRodoviaAdicionais() {
		Formulario formulario = new Formulario();
		formulario.setRodoviaPavimentada(100);
		formulario.setRodoviaNaoPavimentada(0);
		formulario.setCarga(8);
		formulario.setTipoVeiculo(tipoVeiculoService.loadBy("Caminhão caçamba"));
		homeService.calcularFormulario(formulario);
		String resultExpected = brFormat.format(new BigDecimal(62.70));
		assertEquals(resultExpected, formulario.getTotal());		
	}

	@Test
	public void calculaVazio() {
		Formulario formulario = new Formulario();
		homeService.calcularFormulario(formulario);
		String resultExpected = brFormat.format(new BigDecimal(0));
		assertEquals(resultExpected, formulario.getTotal());
	}
}
