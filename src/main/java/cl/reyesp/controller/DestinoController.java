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

import cl.reyesp.model.Destino;
import cl.reyesp.service.DestinoService;
import cl.reyesp.service.PasajeroService;

@Controller //indica que es un controllador de la aplicacion
@RequestMapping({"/","destinos"}) //indica que la clase es el controlador de la pagina destinos
public class DestinoController {

	@Autowired //inyecta el servicio de destino
	private DestinoService destinoService;
	
	
	@Autowired //inyecta el servicio de pasajero
	private PasajeroService pasajeroService;
	
	@GetMapping //indica que es un metodo get (para obtener datos)
	public ModelAndView destinos() {
		ModelAndView modelAndView = new ModelAndView("destinos");  //crear una vista y modelo
		modelAndView.addObject("destinos", destinoService.findAll()); //se agrega un objeto al modelo
		return modelAndView; //retonarmos 
	}
	
	@GetMapping("/crear") //metodo get para crear un destino
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("crear-destino");
		modelAndView.addObject("destino", new Destino()); //se agrega un objeto al modelo
		modelAndView.addObject("pasajeros", pasajeroService.findAll());
		return modelAndView;
	}
	
	@PostMapping("/crear") //indica que es un metodo post (para guardar datos)
	public RedirectView create(@ModelAttribute Destino destino) {
		destinoService.save(destino); //crea el destino en la base de datos 
		return new RedirectView("/destinos"); //redirecciona a la página destinos
	}
	
	@GetMapping("/editar") 
	public ModelAndView update(@RequestParam Long id) {
		ModelAndView modelAndView = new ModelAndView("seleccionar-destino");
		modelAndView.addObject("destino", new Destino()); //objeto para ser llenado en la vista
		modelAndView.addObject("destinoVO", destinoService.findById(id)); //para mostrar los datos en la vista editar
		modelAndView.addObject("pasajeros", pasajeroService.findAll());//se despacha la hacia la vista
		
		return modelAndView; // se retorna el modelo y vista creado 
	}
	
	@PostMapping("/editar")
	public RedirectView update(@ModelAttribute Destino destino) {
		destinoService.update(destino); //actualiza el destino en la base de datos
		return new RedirectView("/destinos");
	}
	
	@GetMapping("/eliminar")
	public RedirectView delete(@RequestParam Long id) {
		Destino destino = destinoService.findById(id); //se busca el destino en la base de datos
		destinoService.delete(destino); //se elimina el destino
		return new RedirectView("/destinos"); //y se despacha a la vista destinos
	}
}
