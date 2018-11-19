package oliveiraluz.com.br.sienge.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import oliveiraluz.com.br.sienge.service.TipoVeiculoFormatter;

@Configuration
@EnableWebMvc
@SuppressWarnings("deprecation")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired	
	private TipoVeiculoFormatter formatter;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(formatter);
	}
}
