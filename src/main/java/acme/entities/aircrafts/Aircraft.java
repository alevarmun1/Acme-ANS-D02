
package acme.entities.aircrafts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.constraints.ValidLongText;
import acme.constraints.ValidShortText;
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
	@ValidShortText
	private String				model;

	@Mandatory
	@Column(unique = true)
	@ValidShortText
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
	@Valid
	@Automapped
	private AircraftStatus		status;

	@Optional
	@ValidLongText
	@Automapped
	private String				details;

	// Derived attributes

	// Relationships

}
