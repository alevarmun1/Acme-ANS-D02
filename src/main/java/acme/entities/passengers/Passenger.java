
package acme.entities.passengers;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(min = 0, max = 256)
	private String				name;

	@Mandatory
	@ValidEmail
	private String				email;

	@Mandatory
	@ValidString(min = 0, pattern = "^[A-Z0-9]{6,9}$")
	private String				passport;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	private Date				dateOfBirth;

	@Optional
	@ValidString(min = 0, max = 51)
	private String				specialNeeds;

	// Relationships
}
