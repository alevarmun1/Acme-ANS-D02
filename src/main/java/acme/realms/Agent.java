
package acme.realms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.entities.airlines.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agent extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2,3}[0-9]{6}$")
	private String				code;

	@Mandatory
	@ValidString
	@Automapped
	private String				languages;

	@Mandatory
	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	private Date				moment;

	@Optional
	@ValidString
	@Automapped
	private String				bio;

	@Optional
	@ValidUrl
	@Automapped
	private String				photo;

	// Relationships ----------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne
	private Airline				airline;
}
