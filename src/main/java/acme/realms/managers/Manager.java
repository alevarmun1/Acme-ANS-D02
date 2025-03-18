
package acme.realms.managers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidManager;
import acme.entities.airlines.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidManager
public class Manager extends AbstractRole {

	// Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$", message = "{validation.manager.identifierNumber}")
	@Column(unique = true)
	private String				identifierNumber;

	@Mandatory
	@ValidNumber(min = 0, max = 120)
	@Automapped
	private int					years;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				dateOfBirth;

	@Optional
	@ValidUrl
	@Automapped
	private String				link;

	// Derived attributes

	// Relationships
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;

}
