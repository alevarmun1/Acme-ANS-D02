
package acme.entities.customers;

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
public class Customer extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	private String				identifier;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	private String				phone;

	@Mandatory
	@ValidString(min = 0, max = 255)
	private String				physicalAddress;

	@Mandatory
	@ValidString(min = 0, max = 50)
	private String				city;

	@Mandatory
	@ValidString(min = 0, max = 50)
	private String				country;

	@Optional
	@ValidNumber(min = 0, max = 500000)
	private Integer				points;

	// Relationships
}
