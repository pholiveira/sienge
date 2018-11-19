package oliveiraluz.com.br.sienge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return buildView(new Formulario());
	}

	@PostMapping
	public ModelAndView calcular(Formulario formulario) {
		this.homeService.calcularFormulario(formulario);
		return buildView(formulario);
	}
	
	private ModelAndView buildView(Formulario formulario) {
		ModelAndView view = new ModelAndView("home");
		view.addObject("formulario", formulario);
		view.addObject("tiposVeiculo", this.tipoVeiculoService.findAll());
		return view;
	}
}
