package oliveiraluz.com.br.sienge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import oliveiraluz.com.br.sienge.application.SiengeApplication;
import oliveiraluz.com.br.sienge.model.Formulario;
import oliveiraluz.com.br.sienge.model.TipoVeiculo;
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
	public void calculaDistancia() {
		BigDecimal actual = homeService.calculaDistancia(80, 20);
		BigDecimal resultExpected = new BigDecimal(55.60);
		assertEquals(resultExpected.setScale(2, RoundingMode.HALF_UP), actual.setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	public void calculaDistanciaVazia() {
		BigDecimal actual = homeService.calculaDistancia(null, null);
		BigDecimal resultExpected = new BigDecimal(0);
		assertEquals(resultExpected.setScale(2, RoundingMode.HALF_UP), actual.setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void calculaAdicional() {
		BigDecimal actual = homeService.calculaAdicional("Caminhão caçamba", new BigDecimal(55.60), 100, 8);
		BigDecimal resultExpected = new BigDecimal(8.78);
		assertEquals(resultExpected.setScale(2, RoundingMode.HALF_UP), actual.setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void calculaAdicionalVazio() {
		BigDecimal actual = homeService.calculaAdicional(null, null, null, null);
		BigDecimal resultExpected = new BigDecimal(0);
		assertEquals(resultExpected.setScale(2, RoundingMode.HALF_UP), actual.setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	public void calcularFormulario() {
		Formulario formulario = new Formulario();
		formulario.setRodoviaPavimentada(100);
		formulario.setRodoviaNaoPavimentada(0);
		formulario.setCarga(8);
		formulario.setVeiculo("Caminhão caçamba");
		homeService.calcularFormulario(formulario);
		String resultExpected = brFormat.format(new BigDecimal(62.70));
		assertEquals(resultExpected, formulario.getTotal());		
	}
	
	@Test
	public void findAllTipoVeiculo() {
		List<TipoVeiculo> tipoVeiculos = tipoVeiculoService.findAll();
		assertTrue(!tipoVeiculos.isEmpty());
	}

	@Test
	public void loadByTipoVeiculo() {
		TipoVeiculo tipoVeiculo = tipoVeiculoService.loadBy("Carreta");
		assertTrue(tipoVeiculo != null);
	}
}
