package oliveiraluz.com.br.sienge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import oliveiraluz.com.br.sienge.model.Formulario;

@Controller
public class HomeController {

	@GetMapping
	public ModelAndView init() {
		ModelAndView view = new ModelAndView("home");
		view.addObject("formulario", new Formulario());
		view.addObject("totalDistancia", 0);
		view.addObject("totalComplementar", 0);
		view.addObject("total", 0);
		return view;
	}

	@PostMapping
	public ModelAndView calculate(Formulario formulario) {
		return init();
	}
}
