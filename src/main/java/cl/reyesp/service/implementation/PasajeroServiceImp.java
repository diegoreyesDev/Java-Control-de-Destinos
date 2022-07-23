package cl.reyesp.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.reyesp.model.Pasajero;
import cl.reyesp.repository.PasajeroRepository;
import cl.reyesp.service.PasajeroService;

@Service //se declara como un servicio
public class PasajeroServiceImp implements PasajeroService {

	@Autowired //inyecta el repositorio pasajero
	private PasajeroRepository pasajeroRepository;
	
	@Override 
	@Transactional(readOnly = true) //indica que este metodo solo puede ser leido, no modificado
	public List<Pasajero> findAll() { //método para obtener una lista de pasajeros
		return pasajeroRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Pasajero pasajero) { //método para crear un pasajero
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void update(Pasajero pasajero) { //método para actualizar un pasajero
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void delete(Pasajero pasajero) { //método para eliminar un pasajero 
		pasajeroRepository.delete(pasajero);

	}

	@Override
	@Transactional(readOnly = true)
	public Pasajero findById(Long id) { //método para obtener un pasajero por su id
		return pasajeroRepository.findById(id).get();
	}

}
