
package acme.entities.airlines;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline extends AbstractEntity {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2}X$", message = "{validation.airline.code}")
	private String				code;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				website;

	@Mandatory
	@Valid
	@Automapped
	private AirlineType			type;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	private Date				foundationMoment;

	@Optional
	@ValidEmail
	@Automapped
	private String				email;

	@Optional
	@Automapped
	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.airline.phoneNumber}")
	private String				phoneNumber;

	// Derived attributes

	// Relationships
}
