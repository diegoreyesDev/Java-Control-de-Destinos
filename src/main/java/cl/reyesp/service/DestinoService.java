package cl.reyesp.service;

import java.util.List;

import cl.reyesp.model.Destino;

public interface DestinoService {

	public List<Destino> findAll(); // Lista de destinos
	public void save(Destino destino); // Guarda un destino
	public void update(Destino destino); // Actualiza un destino
	public void delete(Destino destino); // Elimina un destino
	public Destino findById(Long id); // Busca un destino por id
}
