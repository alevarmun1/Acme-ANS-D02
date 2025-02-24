
package acme.entities.student1;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;

public class Flight extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@NotBlank
	@Size(max = 50)
	private String				tag;

	@NotNull
	private boolean				indication;

	@NotNull
	@Positive
	private double				cost;

	@Length(max = 255)
	private String				description;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@NotBlank
	private String				originCity;

	@NotBlank
	private String				destinationCity;

	@NotNull
	@Min(0)
	@Max(10) // Límite arbitrario para evitar valores extremos
	private int					numberOfLayovers;

	// Derived attributes

	// Relationships
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Manager				manager;
}
