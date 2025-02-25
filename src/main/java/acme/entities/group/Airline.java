
package acme.entities.group;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.components.basis.AbstractEntity;

public class Airline extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@NotBlank
	@Size(max = 50)
	private String				name;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{2}X$", message = "{validation.airline.code}")
	private String				code;

	@URL
	@Length(max = 255)
	private String				website;

	@NotNull
	private AirlineType			type;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	private Date				foundationMoment;

	@Email
	@Length(max = 100)
	private String				email;

	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.airline.phoneNumber}")
	private String				phoneNumber;

	// Derived attributes

	// Relationships
}
