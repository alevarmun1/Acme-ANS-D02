
package acme.entities.group;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.components.basis.AbstractEntity;

public class Airport extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@NotBlank
	@Size(max = 50)
	private String				name;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}$", message = "{validation.airport.code}")
	private String				code;

	@NotNull
	private OperationalScope	operationalScope;

	@NotBlank
	@Size(max = 50)
	private String				city;

	@NotBlank
	@Size(max = 50)
	private String				country;

	@URL
	@Length(max = 255)
	private String				website;

	@Email
	@Length(max = 100)
	private String				email;

	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.airport.contactPhoneNumber}")
	private String				contactPhoneNumber;

	// Derived attributes

	// Relationships
}
