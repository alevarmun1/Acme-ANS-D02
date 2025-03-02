
package acme.entities.aircrafts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.airlines.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@Automapped
	@ValidString(min = 0, max = 50)
	private String				model;

	@Mandatory
	@Column(unique = true)
	@ValidString(min = 0, max = 50)
	private String				registrationNumber;

	@Mandatory
	@Automapped
	@ValidNumber(min = 0)
	private Integer				capacity;

	@Mandatory
	@Automapped
	@ValidNumber(min = 2000, max = 50000)
	private Double				cargoWeigth;

	@Mandatory
	@Automapped
	private boolean				activeService;

	@Optional
	@Automapped
	@ValidString(min = 0, max = 255)
	private String				details;

	// Derived attributes

	// Relationships
	@Mandatory
	@Valid
	@ManyToOne
	private Airline				airline;
}
