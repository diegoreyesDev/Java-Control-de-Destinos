package cl.reyesp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //contructor vacio
@AllArgsConstructor //constructor con parametros
@Data // getter, setter y toString
@Entity //indica que es una entidad en la base de datos
@SequenceGenerator(name = "SQ_PASAJERO", initialValue = 1,allocationSize = 1, sequenceName = "SQ_PASAJERO")//indica cual es la secuencia que se va a usar para generar el id de la entidad
public class Pasajero {

	//atributos
	@Id //el id de la entidad
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASAJERO") //indica que se va a usar la secuencia para generar el id de la entidad
	private Long id;
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	@OneToMany(mappedBy = "pasajero", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //indica relacion 1 amuchos 
	private List<Destino> destino;
}
