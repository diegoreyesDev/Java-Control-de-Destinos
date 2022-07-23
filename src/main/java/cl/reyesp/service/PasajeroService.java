package cl.reyesp.service;

import java.util.List;

import cl.reyesp.model.Pasajero;

public interface PasajeroService {

	public List<Pasajero> findAll(); //Lista de pasajeros
	public void save(Pasajero pasajero); //Guarda un pasajero
	public void update(Pasajero pasajero); //Actualiza un pasajero
	public void delete(Pasajero pasajero); //Elimina un pasajero
	public Pasajero findById(Long id); //buscar un pasajero por su id
}
