package cl.reyesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.reyesp.model.Pasajero;
import cl.reyesp.service.DestinoService;
import cl.reyesp.service.PasajeroService;

@Controller
@RequestMapping({"pasajeros"})
public class PasajeroController {

	@Autowired //se inyecta el servicio pasajero
	private PasajeroService pasajeroService;
	
	@Autowired //se inyecta el servicio destino
	private DestinoService destinoService;
	
	@GetMapping
	public ModelAndView pasajeros() { //método para mostrar los pasajeros en la vista
		ModelAndView modelAndView = new  ModelAndView("pasajeros"); //se crea un modelo y vista 
		modelAndView.addObject("pasajeros", pasajeroService.findAll()); //se le entrega un objeto pasajero
		return modelAndView; //se retorna
	}
	
	@GetMapping("/crear")
	public ModelAndView create() { //metodo pasajeros que retorna una vista con el listado de pasajeros
		ModelAndView modelAndView = new ModelAndView("crear-pasajero"); //
		modelAndView.addObject("pasajero", new Pasajero());
		modelAndView.addObject("destinos", destinoService.findAll());
		return modelAndView;
	}
	
	@PostMapping("/crear")
	public RedirectView create(@ModelAttribute Pasajero pasajero) { //metodo create que retorna una vista con el formulario de creacion de pasajeros
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros");
	}
	
	@GetMapping("/editar")
	public ModelAndView update(@RequestParam Long id) { //metodo retorna una vista con el formulario de edicion de pasajeros
		ModelAndView modelAndView = new ModelAndView("editar-pasajero");
		modelAndView.addObject("pasajero", new Pasajero());
		modelAndView.addObject("pasajeroVO", pasajeroService.findById(id));
		modelAndView .addObject("destinos", destinoService.findAll());
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public RedirectView update(@ModelAttribute Pasajero pasajero) { //metodo que actualiza un pasajero en la base de datos
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros");
	}
	
	@GetMapping("/eliminar")
	public RedirectView delete(@RequestParam Long id) { //método para eliminar un pasajero
		Pasajero pasajero = pasajeroService.findById(id);
		pasajeroService.delete(pasajero);
		return new RedirectView("/pasajeros");
	}
}
