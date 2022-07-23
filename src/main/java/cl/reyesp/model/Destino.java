package cl.reyesp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con parametros
@Data //getters, setters y toString
@Entity //indica la entidad en la base de datos
@SequenceGenerator(name = "SQ_DESTINO", initialValue = 1,allocationSize = 1, sequenceName = "SQ_DESTINO")
public class Destino {

	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DESTINO")
	private Long id;
	private String ciudad;
	private String pais;
	private String fecha;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //relacion mucho a uno
	private Pasajero pasajero;
}
