package oliveiraluz.com.br.sienge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import oliveiraluz.com.br.sienge.model.Formulario;
import oliveiraluz.com.br.sienge.service.HomeService;
import oliveiraluz.com.br.sienge.service.TipoVeiculoService;

@Controller
public class HomeController {

	@Autowired
	private TipoVeiculoService tipoVeiculoService;

	@Autowired
	private HomeService homeService;

	@GetMapping
	public ModelAndView init() {
		return buildView(new Formulario(), null);
	}

	@PostMapping
	public ModelAndView calcular(Formulario formulario, BindingResult bindingResult) {
		this.homeService.calcularFormulario(formulario);
		return buildView(formulario, bindingResult);
	}

	/**
	 * Configura a estrutura Model and View de acordo com os parâmetros informados.
	 * 
	 * @param formulario
	 * @param msgError
	 * @return
	 */
	private ModelAndView buildView(Formulario formulario, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView("home");
		if (bindingResult != null && bindingResult.hasErrors())
			view.addObject("msgError", tratarMsgError(bindingResult.getFieldError()));
		view.addObject("formulario", formulario);
		view.addObject("tiposVeiculo", this.tipoVeiculoService.findAll());
		return view;
	}
	
	/**
	 * Retorna mensagem de acordo com tipo de erro recebido.
	 * 
	 * @return
	 */
	private String tratarMsgError(FieldError error) {
		String msgErro = "Ocorreu um erro durante o processamento, favor tentar novamente.";
		
		if (error.contains(NumberFormatException.class))
			msgErro = "Número no formato inválido! Favor inserir apenas números inteiros.";
		
		return msgErro;
	}
}
