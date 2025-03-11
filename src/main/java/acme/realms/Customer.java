
package acme.realms.customers;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@Column(unique = true)
	@ValidString(min = 1, max = 9, pattern = "^[A-Z]{2,3}\\d{6}$")
	private String				identifier;

	@Mandatory
	@Automapped
	@ValidString(min = 6, max = 15, pattern = "^\\+?\\d{6,15}$")
	private String				phone;

	@Mandatory
	@Automapped
	@ValidString(min = 1, max = 255)
	private String				physicalAddress;

	@Mandatory
	@Automapped
	@ValidString(min = 1, max = 50)
	private String				city;

	@Mandatory
	@Automapped
	@ValidString(min = 1, max = 50)
	private String				country;

	@Optional
	@Automapped
	@ValidNumber(min = 0, max = 500000)
	private Integer				points;

	// Relationships
}
