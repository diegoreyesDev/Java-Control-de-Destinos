package cl.reyesp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.reyesp.model.Destino;

@Repository // Esta clase es un repositorio de Spring Data JPA
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
