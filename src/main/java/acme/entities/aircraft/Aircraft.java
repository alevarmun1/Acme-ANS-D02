
package acme.entities.aircraft;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(min = 0, max = 50)
	private String				model;

	@Mandatory
	@Column(unique = true)
	@ValidString(min = 0, max = 50)
	private String				registrationNumber;

	@Mandatory
	private Integer				capacity;

	@Mandatory
	@ValidNumber(min = 2000, max = 50000)
	private Double				cargoWeigth;

	@Mandatory
	private boolean				activeService;

	@Optional
	@ValidString(min = 0, max = 255)
	private String				email;

	// Derived attributes

	// Relationships
}
