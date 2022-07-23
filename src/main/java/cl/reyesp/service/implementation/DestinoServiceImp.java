package cl.reyesp.service.implementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.reyesp.model.Destino;
import cl.reyesp.repository.DestinoRepository;
import cl.reyesp.service.DestinoService;

@Service
public class DestinoServiceImp implements DestinoService {
	
	private static final Logger log = LoggerFactory.getLogger(DestinoServiceImp.class);

	@Autowired
	private DestinoRepository destinoRepository;
	
	@Override
	@Transactional(readOnly = true) //indica que este metodo solo puede ser leido, no modificado
	public List<Destino> findAll() { //método que retorna un alista de destinos
		log.info("Ejecutando DestinoServiceImp método findAll()");
		return destinoRepository.findAll();
	}

	@Override
	@Transactional //indica que este metodo puede ser modificado
	public void save(Destino destino) { //método para crear un nuevo destino
		log.info("Ejecutando DestinoServiceImp método save()");
		destinoRepository.save(destino);
	}

	@Override
	@Transactional
	public void update(Destino destino) { //método pata actualizar un destino
		log.info("Ejecutando DestinoServiceImp método update()");
		destinoRepository.save(destino);

	}

	@Override
	@Transactional
	public void delete(Destino destino) { //método para eliminar un destino
		log.info("Ejecutando DestinoServiceImp método delete()");
		destinoRepository.delete(destino);

	}

	@Override
	@Transactional(readOnly = true)
	public Destino findById(Long id) { //método para obtener un destino por su id
		log.info("Ejecutando DestinoServiceImp método findById()");
		return destinoRepository.findById(id).get();
	}

}
